#!/usr/bin/env bash

# Downloads an archive, extracts it to a directory, and runs a bazel command
# in the extracted directory.
#
# args:
#  $1 = url to archive
#  $2 = bazel target to build the executable
#  $3 = executable name, e.g, "buildifier"
#  $4 = project name, e.g., "buildtools"
install_tool() {
  bazel_output_base="$(bazel info output_base)"
  tools_directory="${bazel_output_base}/external-tools/"
  output_directory="${tools_directory}/$4-$3"
  version_file="${tools_directory}/$4-$3.version"
  executable_file="${tools_directory}/$3.sh"

  if [ "$1" = "$(cat ${version_file})" ]; then
    echo "$3 already installed"
    return 0
  fi

  echo "Downloading $1"
  rm -rf "${output_directory}" "${version_file}" "${executable_file}"
  mkdir -p "${output_directory}"
  curl -L -sS $1 | tar xzf - --strip 1 -C "${output_directory}"
  cd "${output_directory}"
  echo "Building $3"
  bazel run --color=yes --script_path="${executable_file}" $2 && echo "$1" > "${version_file}"

  # maximum jank!
  #
  # bazel errors if run from a bazel output directory.
  # ibazel runs bazel.
  # The script produced by script_path cd's to the bazel output directory of
  # the downloaded ibazel when we build it. This causes errors, so we delete
  # that line.
  #
  # This is fragile and is likely to break.
  #
  # buildozer has a similar problem.
  if [ "$3" = "ibazel" -o "$3" = "buildozer" ]; then
    sed -i '2d' "${executable_file}"
  fi
}

buildtools_version="8a2894c1a6f957d1a23e2d174e8c3b19bf6a4968"

