package resources.worksheets.chapter1

import sample.project.utils.MyUtils._

object chapter1
{
  foldItrFromFoldRecur[Int, Int](6, _ + _) (List(1, 2, 3))
                                                  //> res0: Int = 12
                                                  
  takeNUsingFold(List(1, 2, 3, 4, 5, 6))(7)       //> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  dropNUsingFold(List(1, 2, 3, 4))(2)             //> res2: List[Int] = List(3, 4)
}