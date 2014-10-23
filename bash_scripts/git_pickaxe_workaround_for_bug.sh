#!/bin/bash

(cd "$1" && git log -S "workaround for bug" "$3"  )
