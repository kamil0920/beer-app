#!/bin/bash
mvn clean install
java -jar ./classes/artifacts/brews_jar/brews.jar
