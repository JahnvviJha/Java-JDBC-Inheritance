#!/bin/bash

echo "⬆️ Compiling Java files..."
javac -cp ".:lib/mysql-connector-java-5.1.49.jar" src/*.java

echo "▶️ Running program..."
java -cp ".:src:lib/mysql-connector-java-5.1.49.jar" Main
