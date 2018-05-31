#!/usr/bin/env sh
cd "$(dirname "$0")"

set -x
echo "Generating dependencies for main workspace"
bazel-deps generate -r "$(pwd)" -s 3rdparty/jvm.bzl -d dependencies.yaml

sed -i '2s!^.*$!load("@rules_scala_annex//rules/external/third_party/bazel/tools/build_defs/repo:java.bzl", "java_import_external")\nload("@rules_scala_annex//rules:external.bzl", "scala_import_external")!' 3rdparty/jvm.bzl
