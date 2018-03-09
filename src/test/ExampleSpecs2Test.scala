package foo

import org.specs2.mutable.SpecificationWithJUnit
import org.specs2.mutable.Specification

class ExampleSpecs2Test extends SpecificationWithJUnit {
  def bar() = {
    1
  }

  "a specs2 test" should {
    "be debuggable in IntelliJ" in {
      val a = bar
      val b = 3
      val c = a + b
      println("specs2: statement 1")
      println("specs2: statement 2")
      println("specs2: statement 3")
      success
    }
  }
}
