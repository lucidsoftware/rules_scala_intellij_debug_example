package foo

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success
import scala.util.Failure

object ScalaBinary {
  def main(args: Array[String]) {
    println("Hello, world1")
    println("Hello, world2")
    println("Hello, world3")

    val testOne = new TestClassOne
    testOne.print

    val testTwo = new TestClassTwo
    testTwo.print

    val testThree = new TestClassThree
    testThree.print

 //    futureTest("kevin").onComplete {
	// 	case Success(n) => {
	// 		println("yes")
	// 		println(n)
	// 	}
	// 	case Failure(ex) => {
	// 		println("no")
	// 	}
	// }
	// Thread.sleep(1100)

	// plus(1)
  }

  @annotation.tailrec
  def plus(num: Int): Int = plus {
  	println(num)
  	num + 1
  }

  def returnMultiple(name: String): (String, Int, String) = {
  	(name, 428, "umich")
  }

  def futureTest(name: String): Future[String] = Future {
	val (testName, testNum, testSchool) = returnMultiple(name)
	// (testName, testNum, testSchool)
	println("in the future")
	name + " great"
  }
}
