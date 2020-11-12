#!/bin/sh

ghc --make Main.hs
echo "1 + 2 * 3 + 4"     | ./Main    # 11
echo "(1 - (2 - 3)) / 2" | ./Main    # 1
