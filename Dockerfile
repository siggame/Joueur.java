FROM siggame/joueur:java-onbuild as build

FROM siggame/joueur:java-base

COPY --from=build --chown=siggame:siggame /usr/src/client/target/java-client-jar-with-dependencies.jar \
                  /client/java-client.jar

