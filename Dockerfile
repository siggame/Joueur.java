FROM siggame/joueur:java-onbuild as build

FROM java:jre-alpine

COPY --from=build /usr/src/client/target/java-client-jar-with-dependencies.jar \
                  /client/java-client.jar
WORKDIR /client

ENTRYPOINT ["java", "-jar", "java-client.jar"]
