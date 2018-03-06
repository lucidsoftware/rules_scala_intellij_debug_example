package foo

import org.specs2.mutable.SpecificationWithJUnit

class ExampleSpecs2Test extends SpecificationWithJUnit {
  "a specs2 test" should {
    "be debuggable in IntelliJ" in {
      println("specs2: statement 1")
      println("specs2: statement 2")
      println("specs2: statement 3")
      success
    }
  }
}
