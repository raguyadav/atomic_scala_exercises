/**
 * Created by sushi on 15-04-23.
 */

import java.io.{BufferedWriter, FileWriter}

import au.com.bytecode.opencsv.CSVWriter

object csvattempt2 extends App {

  println ("sushicsv")

    val out = new BufferedWriter(new FileWriter("/Users/sushi/Documents/workspace/exampleSushi.csv"));
    val writer = new CSVWriter(out);
    val employeeSchema=Array("name","age","dept")

    val employee1= Array("piyush","23","computerscience")

    val employee2= Array("neel","24","computerscience")

    val employee3= Array("aayush","27","computerscience")

    var listOfRecords= List(employeeSchema,employee1,employee2,employee3)



}
