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
    println(names.map(_.toUpperCase)) // List(LP, PL, PP) 不会操作原数据

    // flatmap flat即压扁，压平，扁平化，效果就是将集合中的每个元素的子元素映射到某个函数并返回新的集合
    println(names.flatMap(_.toUpperCase())) // List(L, P, P, L, P, P) 不会操作原数据

    // 化简，折叠，扫描
    val list5 = List(1, 2, 3, 4)
    // 从左到右相减
    val l5 = list5.reduceLeft(_ - _)
    println(l5) // -8
    // 从右到左相减
    val r5 = list5.reduceRight(_ - _)
    println(r5) // -2

    //拉链
    val zip1 = List("15837312345", "137373123456")
    val zip2 = List("A", "B")
    val zipResultList = zip1 zip zip2
    println(zipResultList) // List((15837312345,A), (137373123456,B))
    val zipMap = mutable.Map[String, String]()
    for (e <- zipResultList) {
      zipMap += e
    }
    println(zipMap) // Map(15837312345 -> A, 137373123456 -> B)

    val iter = List(1, 2, 3, 4).iterator
    while (iter.hasNext) {
      println(iter.next())
    }
  }
}
