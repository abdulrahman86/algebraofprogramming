package sample.project.utils


/**
 * @author asattar
 */
package object MyUtils 
{

	def foldItrFromFoldRecur[A, B](c: B, h : (A, B) => B) (list: List[A]) = {

		(fold[A, B => B] ((b) => b, (a, y) => ((b) => y(h(a, b))))(list))(c)
	}

	def fold[A, B](c: B, h : (A, B) => B) (list: List[A]) : B= {

		list match {
		case Nil => c

		case head  :: rest => h(head, fold(c, h)(rest))
		}
	}

	def takeNUsingFold[A] (l: List[A]) : (Int => List[A]) = {

		fold[A, Int => List[A]] (_ => List(), 
				(a, b) => (n) => {if (n > 0) a :: b(n-1) else List()})(l)

	}

	def dropNUsingFold[A] (l: List[A]) : (Int => List[A]) = {
		fold[A, Int => List[A]] (_ => List(), 
				(a, b) => (n) => {if (n > 0) b(n -1) else a :: b(n - 1)})(l)
	}

	def curry[A, B, C] (f : (A, B) => C) : A => B => C= {
			(a : A) => (b : B) => f(a, b)
	}
}