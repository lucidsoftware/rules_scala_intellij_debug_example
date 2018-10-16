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

    val rst1 = futureTest("kevin")
    val rst2 = futureTest("james")
    val rst3 = futureTest("jared")
  }

  def returnMultiple(name: String): (String, Int, String) = {
  	(name, 428, "umich")
  }

  def futureTest(name: String) {
  	val f = Future {
    	val (testName, testNum, testSchool) = returnMultiple(name)
    	(testName, testNum, testSchool)
    }

  	f.onComplete {
    	case Success(n) => {
    		println("yes")
    		println(n._1)
    	}
    	case Failure(ex) => {
    		println("no")
    	}
    }
  }
}
