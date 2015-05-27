/**
 * Created by sushi on 15-05-23.
 */


object AtomicScalaTestCodeSettersGetters extends App {

  println("hello sushi")

  case class Person(name: String, id: Int)

  class Cup2 {
    val max = 100
    var percentFull = 0

    def cupresults(): Unit = {println(percentFull)}
    def add(increase: Int): Int = {
      percentFull += increase
      if (percentFull < 0) percentFull = 0
      else if (percentFull > max) percentFull = max
      percentFull
    }
    def getPercentFull(): Int = {percentFull}
    def setPercentFull(value: Int): Unit = {percentFull = value}
  }

  val cups = new Cup2

  cups.cupresults() // result is 0
  cups.add(45) // result is 45
  cups.cupresults() // result is 50
  cups.add(- 55) // result is 0
  cups.cupresults() // result is 101 NO should be 100
  cups.add(10) //result is 1
  cups.cupresults()
  cups.add(- 9) //result is 1
  cups.cupresults()
  cups.add(- 2) //result is 0
  cups.cupresults()
  cups.percentFull = 56
  assert(cups.percentFull == 56, "Expected 57 got " + cups.percentFull)
  cups.cupresults()
  println (cups.getPercentFull())
  cups.setPercentFull(500)
  println (cups.getPercentFull())
}
