#!/bin/bash

(cd "$1" && git log -S"take care" $3 --pretty=full ) #> "/Users/maldonado/Documents/workspace/XReader/Gitoutput.txt")


