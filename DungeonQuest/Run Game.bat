@echo off
cd /d "%~dp0"
javac src/*.java
java -cp src Main
pause