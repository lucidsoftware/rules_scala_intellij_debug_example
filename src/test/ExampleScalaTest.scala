package foo

import org.scalatest._

class ExampleScalaTest extends WordSpec {
  def bar() = {
    1
  }

  "a ScalaTest test" should {
    "be debuggable in IntelliJ" in {
      val a = bar
      val b = 3
      val c = a + b

      println("ScalaTest: statement 1")
      println("ScalaTest: statement 2")
      println("ScalaTest: statement 3")
    }
  }
}
