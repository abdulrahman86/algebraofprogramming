package resources.worksheets.chapter1

import sample.project.utils.MyUtils._
import sample.project.datastructures.binaryTrees._
import sample.project.datastructures.generalTrees._
import sample.project.datastructures.leftlists._


object chapter1
{
  foldItrFromFoldRecur[Int, Int](6, _ + _) (List(1, 2, 3))
                                                  //> res0: Int = 12
                                                  
  takeNUsingFold(List(1, 2, 3, 4, 5, 6))(7)       //> res1: List[Int] = List(1, 2, 3, 4, 5, 6)
  
  dropNUsingFold(List(1, 2, 3, 4))(2)             //> res2: List[Int] = List(3, 4)
  
  treeMap[Int, Int](_ * 2)(tip(2))                //> res3: sample.project.datastructures.binaryTrees.tree[Int] = tip(4)

	treeDepth[Int](tip(2))                    //> res4: Int = 1
	
	treeDepth[Int](bin(tip(2), bin(tip(3), tip(4))))
                                                  //> res5: Int = 3
                                                  
  treeSize[Int](bin(tip(5), bin(tip(3), tip(4)))) //> res6: Int = 3
 
 	gTreeFold[Int, Int](x => x, (l) => l.foldLeft(0)(_ + _))(node(1, snoc(snoc(NilListl, node(1, NilListl)), node(10, NilListl))))
                                                  //> res7: Int = 12
  
  
  gTreeMap[Int, Int](_ * 2)(node(1, snoc(snoc(NilListl, node(1, NilListl)), node(10, NilListl))))
                                                  //> res8: sample.project.datastructures.generalTrees.gtree[Int] = node(2,snoc(sn
                                                  //| oc(snoc(sample.project.datastructures.leftlists.package$NilListl$@6615435c,n
                                                  //| ode(2,sample.project.datastructures.leftlists.package$NilListl$@6615435c)),n
                                                  //| ode(2,sample.project.datastructures.leftlists.package$NilListl$@6615435c)),n
                                                  //| ode(20,sample.project.datastructures.leftlists.package$NilListl$@6615435c)))
                                                  //| 
                                                  
 gTreeSize[Int](node(1, snoc(snoc(NilListl, node(1, NilListl)), node(10, snoc(NilListl, node(1, NilListl))))))
                                                  //> res9: Int = 4
  
 
 gTreeDepth[Int](node(1, snoc(snoc(NilListl, node(1, NilListl)), node(10, snoc(NilListl, node(1, snoc(NilListl, node(1, NilListl))))))))
                                                  //> res10: Int = 4
                                                  
 zipCurryWithFold[Int, Char](List(1, 2, 3, 4, 5, 6))(List('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'))
                                                  //> res11: List[(Int, Char)] = List((1,A), (2,B), (3,C), (4,D), (5,E), (6,F))
                            
}