package sample.project.utils

import sample.project.datastructures.binaryTrees._
import sample.project.datastructures.generalTrees._
import sample.project.datastructures.leftlists._


/**
 * @author asattar
 */
package object MyUtils 
{

	/**
	 * iterative fold operation for lists
	 */
	def foldItrFromFoldRecur[A, B](c: B, h : (A, B) => B) (list: List[A]) = {

		(fold[A, B => B] ((b) => b, (a, y) => ((b) => y(h(a, b))))(list))(c)
	}

	/**
	 * fold operation for lists
	 */
	def fold[A, B](c: B, h : (A, B) => B) (list: List[A]) : B= {

		list match {
		case Nil => c

		case head  :: rest => h(head, fold(c, h)(rest))
		}
	}

	/**
	 * takes first n elements in a list
	 */
	def takeNUsingFold[A] (l: List[A]) : (Int => List[A]) = {

		fold[A, Int => List[A]] (_ => List(), 
				(a, b) => (n) => {if (n > 0) a :: b(n-1) else List()})(l)

	}

	/**
	 * drops first n elements in a list
	 */
	def dropNUsingFold[A] (l: List[A]) : (Int => List[A]) = {
		fold[A, Int => List[A]] (_ => List(), 
				(a, b) => (n) => {if (n > 0) b(n -1) else a :: b(n - 1)})(l)
	}

	def curry[A, B, C] (f : (A, B) => C) : A => B => C= {
			(a : A) => (b : B) => f(a, b)
	}

	/**
	 * fold operation for binary trees
	 */
	def treeFold[A, B](f: A => B, g : (B, B) => B) (in: tree[A]) : B = {

			in match 
			{
			case tip(a) => f(a)
			case bin(left , right) => g(treeFold(f, g)(left), treeFold[A, B](f, g)(right)) 
			}
	}

	/**
	 * map operation for binary trees
	 */
	def treeMap[A, B](f: A => B)(in: tree[A]): tree[B] = {
			treeFold((x: A) => tip(f(x)), (left: tree[B], right: tree[B]) => bin(left, right))(in)
	}

	/**
	 * tree depth operation for binary trees
	 */
	def treeDepth[A](in: tree[A]): Int = {
			treeFold[A, Int](_ => 1, (x: Int, y: Int) => math.max(x, y) + 1)(in)
	}

	/**
	 * tree size operation for binary trees
	 */
	def treeSize[A](in: tree[A]): Int = {
			treeFold[A, Int](_ => 1, _ + _)(in)
	}

  /**
   * fold operation for general trees
   */
	def gTreeFold[A, B](f: A => B, g: (List[B]) => B)(in: gtree[A]) : B = {

			def getTreesFromListl[A](list: Listl[gtree[A]]) : List[gtree[A]] = {
					list match{
					case NilListl => List()
					case snoc(x, y) => getTreesFromListl(x) ++ List(y)
					}
			}

			in match {

			case node(a, NilListl) => f(a)
			case node(a, list) => g(f(a) :: (for(x <- getTreesFromListl(list)) yield gTreeFold(f, g)(x)))
			}
	}

  /**
   * map operation for general trees
   */
	def gTreeMap[A, B](f: A => B)(in: gtree[A]): gtree[B] ={

			def makeListl[B](list: List[gtree[B]]) : Listl[gtree[B]] = {

					def concatListl[A](x: A, list: Listl[A]) : Listl[A] = 
						{
							list match {
							case NilListl => snoc(NilListl, x)
							case snoc(rest, a) => snoc(concatListl(x, rest), a)
							}
						}

					list match {
					case List() => NilListl
					case x :: rest =>  concatListl(x, makeListl(rest))
					}
			}

			gTreeFold[A, gtree[B]]((a) => node(f(a), NilListl), 
					(list: List[gtree[B]]) => node(list.head.Value, makeListl(list)))(in)
	}

  /**
   * size operation for general trees
   */
	def gTreeSize[A](in: gtree[A]) : Int = {
			gTreeFold[A, Int](x => 1, l => l.fold(0)(_ + _))(in)
	}

  /**
   * depth operation for general trees.
   */
	def gTreeDepth[A](in: gtree[A]) : Int = {
			gTreeFold[A, Int](x => 1, l => 1 + l.tail.foldLeft(0)(math.max(_, _)))(in)
	}

	def zipCurryWithFold[A, B](list1: List[A])(list2: List[B]) : List[(A, B)] = {
  list1.foldRight((a: List[B]) => List[(A, B)]())((a: A, b: List[B] => List[(A,B)]) => 
    {(in: List[B]) => if (in.size == 0) List() else (a, in.head) :: b(in.tail)})(list2)
	}
}