#!/bin/bash

(cd "$1" && git log -S "$2" "$3"  )
