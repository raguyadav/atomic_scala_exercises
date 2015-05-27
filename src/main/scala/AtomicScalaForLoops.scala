/**
 * Created by sushi on 15-05-23.
 */
object AtomicScalaForLoops extends App {

  var result = "" // result as a string

  for (i <- 0 to 9) {result = result + i + " "}
  println (result)

  var result2 = ""
  for (i <- 0 until 10) {result2 += i + " " }
  println (result2)

  var result3 = ""
  for (i <- Range(0,10)) {result3 += i + " "}
  println (result3)

  var result4 = ""
  for (i <- Range(0,20,2)) { result4 += i + " "}
  println (result4)

  var sum = 0
  for (i <- Range(0,20,2)) {
    println ("add " + i + " to sum")
    sum += i
  }
  println(sum)

  // Do exercises when u get home for the for loops from number 3 onwards.

// no 1
  val r1 = Range(0,10)
  println(r1)

  // no2 use the inclusive function on range.
  val r2 = Range(0,10).inclusive
  println(r2)

// no 3
  // write a for loop that adds values 0 through 10 including 10.
  // sumtot must equal 55.
  // must use var instead of val since we reassisgn and add to sumtot
  var sumtot = 0
  for (i <- 0 to 10) {
    sumtot += i
  }
  println(sumtot)

  //no 4
  // write a for loop that adds even numbers between 1 through 10. including 10
  var sumtotEvenonly = 0
  var sumtotOddonly = 0
  for (i <- 1 to 10) {
    if (i % 2 == 0) sumtotEvenonly += i
    else sumtotOddonly += i
  }
  println(sumtotEvenonly)
  println(sumtotOddonly)
  println (sumtotEvenonly + sumtotOddonly)
}



