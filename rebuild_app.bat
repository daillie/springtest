@echo off
START /wait docker-compose down -v
START /wait gradlew clean build -x test
START /wait docker build -t restspring:latest .
if "start"=="%1" (START docker-compose up) else (START docker-compose up --no-start)