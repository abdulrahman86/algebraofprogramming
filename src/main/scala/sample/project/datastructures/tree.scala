package sample.project.datastructures

import sample.project.datastructures.leftlists._

/**
 * @author asattar
 */

package object binaryTrees {

	trait tree[A]{}

case class tip[A](x: A) extends tree[A] {}

case class bin[A](left: tree[A], right: tree[A]) extends tree[A] {}
}

package object generalTrees {

	trait gtree[+A] {
   def Value : A 
  }
  

case class node[+A](value:A, y: Listl[gtree[A]]) extends gtree[A] {
  
  def Value : A = value
}

}