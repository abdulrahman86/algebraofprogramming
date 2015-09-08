package sample.project.datastructures

/**
 * @author asattar
 */
package object leftlists
{
	trait Listl[+A] {

	}

object NilListl extends Listl[Nothing]

case class snoc[+A](list:Listl[A], x: A) extends Listl[A] { 

}
}