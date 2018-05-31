load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

rules_scala_version = "185c3d92b25a1b58deabf049c4db6bc3f69f4c80"  # update this as needed

http_archive(
    name = "io_bazel_rules_scala",
    strip_prefix = "rules_scala-%s" % rules_scala_version,
    #url = "https://github.com/bazelbuild/rules_scala/archive/%s.zip"%rules_scala_version,
    type = "zip",
    url = "https://github.com/lucidsoftware/rules_scala/archive/%s.zip" % rules_scala_version,
)

http_archive(
    name = "rules_scala_annex",
    sha256 = "d25ff8152ae7b71695ad9ba6d8488559d19a80014ffa0817f7b890dff926d3cf",
    strip_prefix = "rules_scala_annex-5222bcc0a0964a210954dae179ff551d99cd9be5",
    url = "https://github.com/lucidsoftware/rules_scala_annex/archive/5222bcc0a0964a210954dae179ff551d99cd9be5.zip",
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
