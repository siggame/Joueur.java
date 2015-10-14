GAMES_FILES = $(shell find games/ -type f -name '*.java')

all:
	mvn clean compile assembly:single
	mkdir -p bin
	make javac

javac:
	javac -cp ".:target/joueur-1.0-jar-with-dependencies.jar" Main.java $(GAMES_FILES) -d ./bin

clean:
	rm -rf ./bin ./target
