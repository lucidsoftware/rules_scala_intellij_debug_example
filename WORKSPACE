load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

#rules_scala_version = "185c3d92b25a1b58deabf049c4db6bc3f69f4c80"  # update this as needed
#http_archive(
#    name = "io_bazel_rules_scala",
#    strip_prefix = "rules_scala-%s" % rules_scala_version,
#    #url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip"%rules_scala_version,
#    type = "zip",
#    url = "https://github.com/lucidsoftware/rules_scala/archive/%s.zip" % rules_scala_version,
#)

#rules_scala_annex_version = "3ff7afae2590d718944439a0bd69c16866709b30"
#http_archive(
#    name = "rules_scala_annex",
#    sha256 = "08cecc61ff813b6e083983fe9e1f0d15dd8439a119366c8b5a2568f6f651bc8e",
#    strip_prefix = "rules_scala_annex-%s" % rules_scala_annex_version,
#    url = "https://github.com/andyscott/rules_scala_annex/archive/%s.zip" % rules_scala_annex_version,
#)

local_repository(
    name = "rules_scala_annex",
    path = "/home/borkaehw/Desktop/code/rules_scala_annex",
)

load("@rules_scala_annex//rules/scala:workspace.bzl", "annex_scala_repositories", "annex_scala_repository", "annex_scala_register_toolchains")

annex_scala_repositories()

annex_scala_register_toolchains()

annex_scala_repository(
    "scala",
    ("org.scala-lang", "2.11.11"),
    "@compiler_bridge_2_11//:src",
)

register_toolchains("@rules_scala_annex//rules/scala:config_runner_toolchain")

load("//3rdparty:jvm.bzl", "maven_dependencies")

maven_dependencies()

http_archive(
    name = "com_google_protobuf",
    sha256 = "cef7f1b5a7c5fba672bec2a319246e8feba471f04dcebfe362d55930ee7c1c30",
    strip_prefix = "protobuf-3.5.0",
    urls = ["https://github.com/google/protobuf/archive/v3.5.0.zip"],
)
