# Do not edit. bazel-deps autogenerates this file from dependencies.yaml.
load("@rules_scala_annex//rules/external/third_party/bazel/tools/build_defs/repo:java.bzl", "java_import_external")
load("@rules_scala_annex//rules:external.bzl", "scala_import_external")

def declare_maven(hash):
    lang = hash.pop("lang")
    import_args = hash["import_args"]

    # TODO: Change this back once java_import works again
    # if lang == "java":
    if False:
        java_import_external(**import_args)
    else:
    #elif lang.startswith("scala"):
        if "testonly_" in import_args:
            import_args.pop("testonly_")
        if "neverlink" in import_args:
            import_args.pop("neverlink")

        scala_import_external(**import_args)

    native.bind(**hash["bind_args"])

def list_dependencies():
    return [
        {
            "bind_args": {
                "actual": "@org_scala_lang_modules_scala_parser_combinators_2_11",
                "name": "jar/org/scala_lang/modules/scala_parser_combinators_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "5baaad7be5c6fc8142a31ab003f7ee797e488ee137d48df5d9c3c2b3fb0c5bc6",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.11/1.1.0/scala-parser-combinators_2.11-1.1.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scala_lang_modules_scala_parser_combinators_2_11",
                "srcjar_sha256": "15ffea5d33cb831220573c7556ad36653599b92abebf7c5f90b7b9fc5cc275fc",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-parser-combinators_2.11/1.1.0/scala-parser-combinators_2.11-1.1.0-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_scala_lang_modules_scala_xml_2_11",
                "name": "jar/org/scala_lang/modules/scala_xml_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "a3ec190294a15a26706123f140a087a8c0a5db8980e86755e5b8e8fc33ac8d3d",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-xml_2.11/1.0.6/scala-xml_2.11-1.0.6.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scala_lang_modules_scala_xml_2_11",
                "srcjar_sha256": "02a63308c374fd82db89fba59739bd1f30ec160cf8e422f9d26fde07274da8b0",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/modules/scala-xml_2.11/1.0.6/scala-xml_2.11-1.0.6-sources.jar"
                ]
            },
            "lang": "java"
        },
        # duplicates in org.scala-lang:scala-library promoted to 2.11.12
        # - org.scalatest:scalatest_2.11:3.0.5 wanted version 2.11.12
        # - org.specs2:specs2-core_2.11:4.2.0 wanted version 2.11.11
        {
            "bind_args": {
                "actual": "@org_scala_lang_scala_library",
                "name": "jar/org/scala_lang/scala_library"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "0b3d6fd42958ee98715ba2ec5fe221f4ca1e694d7c981b0ae0cd68e97baf6dce",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/scala-library/2.11.12/scala-library-2.11.12.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scala_lang_scala_library",
                "srcjar_sha256": "a32ccfac851adeb094a31134af1034d0ba026512931433cba86d5dd12d91f1ff",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/scala-library/2.11.12/scala-library-2.11.12-sources.jar"
                ]
            },
            "lang": "java"
        },
        # duplicates in org.scala-lang:scala-reflect promoted to 2.11.12
        # - org.scalatest:scalatest_2.11:3.0.5 wanted version 2.11.12
        # - org.specs2:specs2-common_2.11:4.2.0 wanted version 2.11.11
        {
            "bind_args": {
                "actual": "@org_scala_lang_scala_reflect",
                "name": "jar/org/scala_lang/scala_reflect"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "6ba385b450a6311a15c918cf8688b9af9327c6104f0ecbd35933cfcd3095fe04",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/scala-reflect/2.11.12/scala-reflect-2.11.12.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scala_lang_scala_reflect",
                "srcjar_sha256": "4d4adbc4f5f6be87ec555635dd40926bf71c6d638a06d59d929de04386099063",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-lang/scala-reflect/2.11.12/scala-reflect-2.11.12-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_scala_sbt_test_interface",
                "name": "jar/org/scala_sbt/test_interface"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "15f70b38bb95f3002fec9aea54030f19bb4ecfbad64c67424b5e5fea09cd749e",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scala_sbt_test_interface",
                "srcjar_sha256": "c314491c9df4f0bd9dd125ef1d51228d70bd466ee57848df1cd1b96aea18a5ad",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scala-sbt/test-interface/1.0/test-interface-1.0-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_scalactic_scalactic_2_11",
                "name": "jar/org/scalactic/scalactic_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "84723064f5716f38990fe6e65468aa39700c725484efceef015771d267341cf2",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scalactic/scalactic_2.11/3.0.5/scalactic_2.11-3.0.5.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scalactic_scalactic_2_11",
                "srcjar_sha256": "b58cd691c1eda023e349e840ee55eb289ac5789c9642b5ac427932747ca38d52",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scalactic/scalactic_2.11/3.0.5/scalactic_2.11-3.0.5-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_scalatest_scalatest_2_11",
                "name": "jar/org/scalatest/scalatest_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "deps": [
                    "@org_scala_lang_modules_scala_xml_2_11",
                    "@org_scala_lang_scala_library",
                    "@org_scala_lang_scala_reflect",
                    "@org_scalactic_scalactic_2_11"
                ],
                "jar_sha256": "2aafeb41257912cbba95f9d747df9ecdc7ff43f039d35014b4c2a8eb7ed9ba2f",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scalatest/scalatest_2.11/3.0.5/scalatest_2.11-3.0.5.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_scalatest_scalatest_2_11",
                "srcjar_sha256": "99966e19996488c5e08b73ebf8baad0ec456aa03e6b167814f7a587b2f50230c",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/scalatest/scalatest_2.11/3.0.5/scalatest_2.11-3.0.5-sources.jar"
                ]
            },
            "lang": "scala"
        },
        {
            "bind_args": {
                "actual": "@org_specs2_specs2_common_2_11",
                "name": "jar/org/specs2/specs2_common_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "deps": [
                    "@org_scala_lang_modules_scala_parser_combinators_2_11",
                    "@org_scala_lang_modules_scala_xml_2_11",
                    "@org_scala_lang_scala_reflect",
                    "@org_specs2_specs2_fp_2_11"
                ],
                "jar_sha256": "172162b9a46bd54a1165bac1caf0476368d876504c5a827d23b056ad7ef2ef1c",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-common_2.11/4.2.0/specs2-common_2.11-4.2.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_specs2_specs2_common_2_11",
                "srcjar_sha256": "8a5cef778a781db5b5ed36b104ff8c5d015c391834524f54b872918b496ef45f",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-common_2.11/4.2.0/specs2-common_2.11-4.2.0-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_specs2_specs2_core_2_11",
                "name": "jar/org/specs2/specs2_core_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "deps": [
                    "@org_scala_lang_scala_library",
                    "@org_scala_sbt_test_interface",
                    "@org_specs2_specs2_matcher_2_11"
                ],
                "jar_sha256": "4794ce08b8f394bb2a00886e89e9d5d5aeb9934cfe20fe300d4a51eb72b9a9f2",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-core_2.11/4.2.0/specs2-core_2.11-4.2.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_specs2_specs2_core_2_11",
                "srcjar_sha256": "bfb302bfe2fa542810643502137ac0b78977f0921efc03c4af8664c75c283f0b",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-core_2.11/4.2.0/specs2-core_2.11-4.2.0-sources.jar"
                ]
            },
            "lang": "scala"
        },
        {
            "bind_args": {
                "actual": "@org_specs2_specs2_fp_2_11",
                "name": "jar/org/specs2/specs2_fp_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "jar_sha256": "2340c61968c21ca68c859c8fc1290511db24eac015eaccd265cbec721f78a5e1",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-fp_2.11/4.2.0/specs2-fp_2.11-4.2.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_specs2_specs2_fp_2_11",
                "srcjar_sha256": "37ee277ffd7be0b9dcc4ceec66b6231fc5e97393dc9f8a5bf31f1e49482d908f",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-fp_2.11/4.2.0/specs2-fp_2.11-4.2.0-sources.jar"
                ]
            },
            "lang": "java"
        },
        {
            "bind_args": {
                "actual": "@org_specs2_specs2_matcher_2_11",
                "name": "jar/org/specs2/specs2_matcher_2_11"
            },
            "import_args": {
                "default_visibility": [ "//visibility:public" ],
                "deps": [ "@org_specs2_specs2_common_2_11" ],
                "jar_sha256": "920d48020f8309ab747a54d6e4e2496a00fef83c5fb349322e925f61e644fa08",
                "jar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-matcher_2.11/4.2.0/specs2-matcher_2.11-4.2.0.jar"
                ],
                "licenses": [ "notice" ],
                "name": "org_specs2_specs2_matcher_2_11",
                "srcjar_sha256": "bfc9c92a719581cb2289334085a2b666e060732f06fc7349d42adf092b4d0361",
                "srcjar_urls": [
                    "https://repo.maven.apache.org/maven2/org/specs2/specs2-matcher_2.11/4.2.0/specs2-matcher_2.11-4.2.0-sources.jar"
                ]
            },
            "lang": "java"
        }
    ]
def maven_dependencies(callback = declare_maven):
    for hash in list_dependencies():
        callback(hash)

    