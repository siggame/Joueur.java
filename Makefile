GAME_NAME = $(shell ls ./games/)
LETTER = $(call substr,$(GAME_NAME),1,1)
GAME_NAME_UPPER = $(shell sed -e "s/\b\(.\)/\u\1/g" $(GAME_NAME))
GAMES_FILES = $(shell find games/ -type f -name '*.java')

all:
	make dependencies
	make core

dependencies:
	mvn clean compile assembly:single

core:
	mkdir -p bin
	javac -cp ".:target/joueur-1.0-jar-with-dependencies.jar" Main.java $(GAMES_FILES) -d ./bin

docs:
	#javadoc games.$(GAME_NAME) -d ./docs -windowtitle "$(GAME_NAME_UPPER) Java Client Documentation" -top "<header class=\"bar\" style=\"font-size: 2em;\">$(GAME_NAME_UPPER) Java Client Documentation</header>"
	echo $(LETTER)

clean:
	rm -rf ./bin ./target ./docs
