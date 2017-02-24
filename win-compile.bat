:: output all the java files found to a temp file
@dir /s /B *.java > sources.txt

@SETLOCAL EnableDelayedExpansion

:: read them back into a variable... because batch is silly
@for /f "Tokens=* Delims=" %%x in (sources.txt) do @set Build=!Build! !%%x

:: delete the temp file
@del sources.txt

:: ensure bin directory exists
@if not exist "bin" @mkdir bin

:: finally, compile!
@javac -cp target/joueur-1.0-jar-with-dependencies.jar -sourcepath ./ -d ./bin %Build%
