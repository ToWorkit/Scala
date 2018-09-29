package base

import scala.collection.mutable

object list {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2)
    println(list(1)) // 2
    // 不允许修改
/*    list(1) = 3
    println(list)*/

    // 追加，结尾必须是一个空列表(Nil)或者列表
    // Nil => List[Nothing]
    val list2 = 1 :: 2 :: 3 :: Nil
    println(list2) // List(1, 2, 3)

    val list3 = 3 :: 4 :: List(1, 2)
    println(list3) // List(3, 4, 1, 2)

    val list4 = mutable.ListBuffer[Int]()
    list4.append(1, 2)
    println(list4) // ListBuffer(1, 2)
    // 不写 . 也行
    list4 update(0, 10)
    println(list4) // ListBuffer(10, 2)

    // 空列表
    val nullList: List[Nothing] = List()
    // 二维列表
    val erList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    println(erList) // List(List(1, 2, 3), List(4, 5, 6))

    // map 将集合中的每一个元素映射到某一个函数
    val names = List("lp", "pl", "pp")
    println(names.map(_.toUpperCase)) // List(LP, PL, PP)
  }
}
