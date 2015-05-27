/**
 * Created by sushi on 15-04-23.
 */

import java.io.File

import com.github.tototoshi.csv.CSVWriter

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.jdbc.StaticQuery.interpolation
import scala.slick.jdbc.meta.MTable
import scala.slick.jdbc.{StaticQuery => Q}

object BootStrap extends App {


    val alexurl = "jdbc:mysql://mtl-alex01.sv.stw/billing_sushi?allowMultiQueries=true"
    val alexdb =  Database.forURL(alexurl, user = "sushi", password = "jbilling2", driver = "com.mysql.jdbc.Driver")


  val localurl = "jdbc:mysql://localhost/test?allowMultiQueries=true"
  val localdb = Database.forURL(localurl, user = "root", password = "", driver = "com.mysql.jdbc.Driver")

  // create a table first in slick
  case class Clients(id: Int, userName: String, name: String)

  // We need to define Table row classes for our database schema
  // This describes the structure of our database tables.
  // ClientInfo is called a Table Row Class.
  class ClientInfo (tag: Tag) extends Table[(Int,String,String)](tag, "CLIENTS_INFO") {
    def id = column[Int] ("ID")                 // All columns are defined by column method
    def userName = column[String] ("USER_NAME")
    def name = column[String] ("NAME")
    def * = (id, userName, name) // Every table requires a * method containing a dafault projection
    // It describes what you get back when you return rows from a query in the form of a table row object
    // Slick’s * projection does not have to match the one in the database.
    // You can add new columns (e.g. with computed values) or omit some columns as you like.
  }
  val clientsInfo = TableQuery[ClientInfo] //you need a TableQuery value which represents the actual database table:

  // Create a table clients_info in the database
  localdb.withSession { implicit session =>
    if (MTable.getTables("CLIENTS_INFO").list.isEmpty)
      clientsInfo.schema.create
  }



  def createClientList(x: (Int,String,String)) = {Seq (x._1,x._2,x._3) }



  def createClientObjects(x: (Int,String,String)) = {Seq (new Clients(x._1,x._2,x._3))  }

  val jb2ClientsInfoquery =  alexdb.withSession { implicit session =>
      sql""" select * from jb2_user limit 10 """.as[(Int,String,String)].list }

  // println (jb2ClientsInfoquery map createClientObjects)
     val listOfClientObjects =  jb2ClientsInfoquery map createClientObjects
     val listofClients       = jb2ClientsInfoquery map createClientList


  def csvBuilder(objectList : List[Clients]) : String = { objectList.map(_.toString()).mkString("\n")}

  def csvBuilderfromSQlList(sqlList: List[(Int,String,String)]) = {sqlList.map(_.toString())}

//  val csv = csvBuilder(listOfClientObjects)
//  println (csv)

//  val csv2 = "id, user_name, name\n"   + csvBuilderfromSQlList(jb2ClientsInfoquery)
   val csv2 =  csvBuilderfromSQlList(jb2ClientsInfoquery)

  println (csv2)


  val f = new File("/Users/sushi/Documents/workspace/out.csv")
  val writer = CSVWriter.open(f)

  // listOfClientObjects is Seq[clients] and i want to map it to a Seq[(String,String)]
 // writer.writeAll(listOfClientObjects)   THIS ONE WORKS

  // AND THIS WORKS THE BEST
   writer.writeAll(listofClients)




  //  writer.writeAll(Seq(jb2ClientsInfoquery))
//  writer.writeAll(Seq(csv2))

  writer.close





}