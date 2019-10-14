#	Assignment makefile - uses GNU make to build and test
#
#   Contributors:
#    Aaron S. Crandall <acrandal@wsu.edu>, 2019
#
#	To use:
#    1) Install GNU make
#    2) make build
#    3) make test
#    4) make clean

MAIN_SRC_FILE=BSTAddRemove_main

build:
	javac -cp ./lib/junit4.jar *.java

test: build
	java -cp ./lib/junit4.jar:. $(MAIN_SRC_FILE)

clean:
	rm *.class
