#!/bin/bash

(cd "$1" && git log -S "bail out" "$3")


