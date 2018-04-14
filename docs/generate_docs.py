#!/usr/bin/env python3 -B

from __future__ import print_function

import os
import os.path
import subprocess
import shutil
import markdown # this is a pip package you'll need
import re
from datetime import date
import sys

def splitall(path):
    allparts = []
    while 1:
        parts = os.path.split(path)
        if parts[0] == path:  # sentinel for absolute paths
            allparts.insert(0, parts[0])
            break
        elif parts[1] == path: # sentinel for relative paths
            allparts.insert(0, parts[1])
            break
        else:
            path = parts[0]
            allparts.insert(0, parts[1])
    return allparts

def run(*args, **kwargs):
    error_code = subprocess.call(*args, **kwargs)
    if error_code != 0: # an error happened
        raise Exception()

output_path = "./output"
if os.path.isdir(output_path):
    shutil.rmtree(output_path)

with open('../README.md', 'r') as readme_file:
    readme_md = readme_file.read()

# readme_md = readme_md.replace("GAME_NAME", game_name).replace("game_name", lower_game_name)

temp_path = 'temp/'
if os.path.isdir(temp_path):
    shutil.rmtree(temp_path)

shutil.copytree("../src/main/java", temp_path)

with open(os.path.join(temp_path, "overview.html"), "w+") as readme_html:
    # TODO: this file is not being picked up, so the readme is not included in the docs
    readme_html.write("<html><head></head><body>" + markdown.markdown(readme_md) + "</body></html>")

shutil.copytree('resources', os.path.join(output_path, 'resources'))

get_settings_function = """
    /**
     * Gets an AI setting passed to the program via the `--aiSettings` flag. If the flag was set it will be returned as a string value, null otherwise.
     *
     * @param key The key of the setting you wish to get the value for
     * @return A string representing the value set via command line, or null if the key was not set
     */
    public String getSetting(String key) {
        return null; // this is just for output
    }
"""

game_desc_re = re.compile('(?<= \\* ).*')
for root, dirnames, filenames in os.walk(os.path.join(temp_path, 'games')):
    for filename in filenames:
        if filename != "AI.java":
            continue

        with open(os.path.join(root, filename), 'r+') as ai_file:
            ai_lines = ai_file.readlines()

            for index in reversed(range(len(ai_lines))):
                if ai_lines[index].strip() == '}':
                    ai_lines[index:index] = get_settings_function
                    break

            ai_file.seek(0)
            ai_file.write(''.join(ai_lines))

    for lower_game_name in dirnames:
        game_name = lower_game_name[0].upper() + lower_game_name[1:]

        with open(os.path.join('../src/main/java/games/', lower_game_name, 'Game.java'), 'r') as game_file:
            contents = game_file.read()

        game_desc = game_desc_re.search(contents).group()
        with open(os.path.normpath(os.path.join(root, lower_game_name, 'package-info.java')), 'w+') as file:
            file.write("""/**
 * {game_desc}
 * <h2>Rules</h2>
 * <p>
 * The full game rules for {game_name} can be found on <a target="_blank" href="https://github.com/siggame/Cadre/blob/master/Games/{game_name}/rules.md">GitHub</a>.
 * <p>
 * Additional materials, such as the <a target="_blank" href="https://github.com/siggame/Cadre/blob/master/Games/{game_name}/story.md">story</a> and <a target="_blank" href="https://github.com/siggame/Cadre/blob/master/Games/{game_name}/creer.yaml">game template</a> can be found on <a target="_blank" href="https://github.com/siggame/Cadre/blob/master/Games/{game_name}/">GitHub</a> as well.
 */
package games.{lower_game_name};
""".format(game_name=game_name, game_desc=game_desc, lower_game_name=lower_game_name))

try:
    run(('javadoc -d {output_path} '
        '-overview "{temp_path}/overview.html" '
        '-public '
        '-use -windowtitle "Java Joueur Client Documentation" '
        '-header "<h1>Java Joueur Client Documentation</h1>" '
        '-bottom "&copy; {year} MST ACM SIG-GAME" '
        '-sourcepath {temp_path} '
        '-subpackages games').format(
        output_path=output_path,
        temp_path=temp_path,
        year=date.today().year,
    ), shell=True)
except:
    print("javadoc creation had a problem but should be ok...")

# inject favicon into output
HEAD_TAG = "<head>"
shutil.copyfile('favicon.ico', os.path.join(output_path, 'favicon.ico'))
dot_dirs = len(splitall(output_path))
for root, dirnames, filenames in os.walk(output_path):
    root = os.path.normcase(root)
    for filename in filenames:
        if not filename.endswith('.html'):
            continue

        n = (len(splitall(root)) - dot_dirs)
        with open(os.path.join(root, filename), "r+") as file:
            contents = file.read()
            index = contents.find(HEAD_TAG) + len(HEAD_TAG)
            contents = contents[:index] + """
<link rel="shortcut icon" href="./{}favicon.ico" />
""".format("../" * n) + contents[index:]
            file.seek(0)
            file.write(contents)

print("Java docs generated...")

shutil.rmtree(temp_path)
