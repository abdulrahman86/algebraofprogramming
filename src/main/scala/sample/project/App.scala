package sample.project

import sample.project.utils.MyUtils._
import sample.project.datastructures.binaryTrees._
import sample.project.datastructures.generalTrees._
import sample.project.datastructures.leftlists._


/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    println( "Hello World!" )
    println("concat arguments = " + foo(args))
    
    println(gTreeFold[Int, Int](x => x + 1, (l) => l.foldLeft(0)(_ + _))(node(1, snoc(snoc(NilListl, node(1, NilListl)), node(10, NilListl)))))
  }

}
