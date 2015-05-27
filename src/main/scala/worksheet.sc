// You want to convert a string
// to one of scalas numeric type
class Giraffe {println("This is a girafffe")}

val girrafe1 = new Giraffe

class Dog {


  def bark: String = { return "Woof" }
  def loud: String = {bark + " Loudly"}
}

val doggie = new Dog
val value = doggie.bark
val value2 = doggie.loud

assert(value == "Woof", "Expected Woof got " + value)

assert("Woof Loudly" == value2, "Excepted Woof Loudly got" + value2)

//“assert("mew!" == m1,
//9     "Expected mew!, Got " + m1)”
