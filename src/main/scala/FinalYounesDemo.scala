/**
 * Created by sushi on 15-04-23.
 */

import java.io.File

import com.github.tototoshi.csv.CSVWriter

import scala.slick.driver.MySQLDriver.simple._
import scala.slick.jdbc.StaticQuery.interpolation
import scala.slick.jdbc.{StaticQuery => Q}

object FinalYounesDemo extends App {

  val alexurl = "jdbc:mysql://mtl-alex01.sv.stw/billing_sushi?allowMultiQueries=true"
  val alexdb =  Database.forURL(alexurl, user = "sushi", password = "jbilling2", driver = "com.mysql.jdbc.Driver")


  def createClientList(x: (Int,String,String)) = {Seq (x._1,x._2,x._3) }


  val jb2ClientsInfoquery =  alexdb.withSession { implicit session =>
    sql""" select id as ID, user_name as UserName, name as ClientName  from jb2_user limit 10 """.as[(Int,String,String)].list }


  val listofClients = jb2ClientsInfoquery map createClientList


 // val f = new File("/Users/sushi/Documents/workspace/csv/younesoutput.csv")
 // val writer = CSVWriter.open(f)

  val filename = new File("/Users/sushi/Documents/workspace/csv/younesoutput.csv")
  val writer = CSVWriter.open(filename)

  writer.writeRow(Seq("id","user_name","name"))
  writer.writeAll(listofClients)
  writer.close
}
