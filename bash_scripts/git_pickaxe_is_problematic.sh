#!/bin/bash

(cd "$1" && git log -S "is problematic" "$3"  )


