package foo

object ScalaBinary {
  def main(args: Array[String]) {
    println("Hello, world1")
    println("Hello, world2")
    println("Hello, world3")

    val testOne = new TestClassOne
    testOne.print
    val testTwo = new TestClassTwo
    testTwo.print
  }
}
