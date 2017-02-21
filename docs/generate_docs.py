import os
import os.path
import subprocess
import argparse
import shutil
import markdown # this is a pip package you'll need
from datetime import date
import sys

def run(*args, **kwargs):
    error_code = subprocess.call(*args, **kwargs)
    if error_code != 0: # an error happened
        sys.exit(error_code)

parser = argparse.ArgumentParser(description='Runs the java client doc generation script.')
parser.add_argument('game', action='store', help='the name of the game you want to document. Must exist in ../games/')

args = parser.parse_args()

game_name = args.game[0].upper() + args.game[1:]
lower_game_name = game_name[0].lower() + game_name[1:]

output_path = "./output"
if os.path.isdir(output_path):
    shutil.rmtree(output_path)

with open('../README.md', 'r') as readme_file:
    readme_md = readme_file.read()

readme_md = readme_md.replace("GAME_NAME", game_name).replace("game_name", lower_game_name)

temp_readme_html_path = os.path.join("..", "games", lower_game_name, "package.html")

with open(temp_readme_html_path, "w+") as readme_html:
    readme_html.write("<html><head></head><body>" + markdown.markdown(readme_md) + "</body></html>")

run(["javadoc -d {output_path} -use -windowtitle \"{game_name} Java Client Documentation\" -header \"<h1>{game_name} Java Client Documentation</h1>\" -bottom \"&copy; {year} MST ACM SIG-GAME\" -sourcepath .. games.{lower_game_name}".format(
    output_path=output_path,
    game_name=game_name,
    lower_game_name=lower_game_name,
    year=date.today().year,
)], shell=True)

os.remove(temp_readme_html_path)
