#!/usr/bin/env python3 -B

from __future__ import print_function

import os
import os.path
import subprocess
import shutil
import markdown # this is a pip package you'll need
from datetime import date
import sys


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
temp_readme_html_path = os.path.join(temp_path, 'games', "package.html")

with open(temp_readme_html_path, "w+") as readme_html:
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

try:
    run(('javadoc -d {output_path} '
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

shutil.rmtree(temp_path)
