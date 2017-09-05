GAMES_FILES = $(shell find games/ -type f -name '*.java')

all:
	make dependencies
	make core

dependencies:
	mkdir -p ./src/main/java/
	cp -r ./games ./joueur Main.java ./src/main/java/
	mvn dependency:go-offline

core:
	mvn -o clean compile assembly:single

clean:
	rm -rf ./bin ./target ./src
