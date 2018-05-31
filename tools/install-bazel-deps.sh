#!/usr/bin/env bash

script=$(readlink -f "$0")
scriptpath=$(dirname "$script")

source "${scriptpath}/install-tool.sh"

install_tool \
  "https://github.com/lucidsoftware/bazel-deps/archive/b95e44421a6f1f9ade584154b00a91bf9d53dde9.tar.gz" \
  "parse" \
  "bazel-deps" \
  "bazel-deps"
