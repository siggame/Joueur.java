GAMES_FILES = $(shell find games/ -type f -name '*.java')

all:
	make dependencies
	make core

dependencies:
	mvn clean compile assembly:single

core:
	mkdir -p bin
	javac -cp ".:target/joueur-1.0-jar-with-dependencies.jar" Main.java $(GAMES_FILES) -d ./bin

clean:
	rm -rf ./bin ./target
