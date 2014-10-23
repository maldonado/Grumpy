#!/bin/bash

(cd "$1" && git log -S "this is wrong" "$3"  )


