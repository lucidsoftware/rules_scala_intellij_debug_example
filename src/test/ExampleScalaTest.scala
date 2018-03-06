package foo

import org.scalatest._

class ExampleScalaTest extends WordSpec {
  "a ScalaTest test" should {
    "be debuggable in IntelliJ" in {
      println("ScalaTest: statement 1")
      println("ScalaTest: statement 2")
      println("ScalaTest: statement 3")
    }
  }
}
