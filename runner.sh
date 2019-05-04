#!/usr/bin/env bash
python interactive_runner.py python testing_tool.py 0 -- java -cp ./target/classes -agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=127.0.0.1:1044 Solve

python interactive_runner.py python testing_tool.py 0 -- java -cp ./target/classes Solution
