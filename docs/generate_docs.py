import os
import os.path
import subprocess
import argparse
import shutil
from datetime import date

parser = argparse.ArgumentParser(description='Runs the java client doc generation script.')
parser.add_argument('game', action='store', help='the name of the game you want to document. Must exist in ../games/')

args = parser.parse_args()

game_name = args.game[0].upper() + args.game[1:]
lower_game_name = game_name[0].lower() + game_name[1:]

output_path = "./output"
if os.path.isdir(output_path):
    shutil.rmtree(output_path)

subprocess.call(["javadoc -d {output_path} -windowtitle \"{game_name} Java Client Documentation\" -header \"<h1>{game_name} Java Client Documentation</h1>\" -bottom \"&copy; {year} MST ACM SIG-GAME\" -sourcepath .. games.{lower_game_name}".format(
    output_path=output_path,
    game_name=game_name,
    lower_game_name=lower_game_name,
    year=date.today().year
)], shell=True)
