package base

object Function_02 {
  def main(args: Array[String]): Unit = {
    val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

    // 过滤
    println(nums.filter((i: Int) => i % 2 == 0)) // List(2, 4, 6, 8)
    println(nums.filter(_ % 2 == 0)) // List(2, 4, 6, 8)
    // zip 将两个列表的元素合成一个由元素对组成的列表里
    println(List(1, 2, 3).zip(List(4, 5, 6))) // List((1,4), (2,5), (3,6))

    // partition 根据断言函数(过滤条件)的返回值对列表进行分区
    println(nums.partition((i: Int) => i % 2 == 0)) // (List(2, 4, 6, 8),List(1, 3, 5, 7))


    // find 返回集合中第一个符合条件的元素
    println(nums.find(_ % 3 == 0).getClass) // Some(3) class scala.Some
    val a = nums.find(_ % 3 == 0).toArray
    println(a(0) + 2) // 5

    // foreach 对列表中的每一个元素应用一个函数，没有返回值
    println(nums.foreach((i: Int) => i * 2)) // ()
    nums.foreach(print) // 12345678
    println("")

    // map 对列表中的每个元素应用一个函数并返回
    println(nums.map(_ * 2)) // List(2, 4, 6, 8, 10, 12, 14, 16)

    // flatten 把嵌套的结构展开
    println(List(List(1, 2, 3), List(4, 5, 6)).flatten) // List(1, 2, 3, 4, 5, 6)

    // flatMap combinator结合了map和flatten的功能
    println(List(List(1, 2, 3), List(4, 5, 6)).flatMap(x => x.map(_ * 2))) // List(2, 4, 6, 8, 10, 12)
    println(List(List(1, 2, 3), List(4, 5, 6)).flatMap(_.map(_ * 2))) // List(2, 4, 6, 8, 10, 12)

    /**
      * 有些地方
      *   (x => x * 2)
      * 不能简写为
      *   (_ * 2)
      * 因为
      *   Scala 会将其解析为 ((y => x * 2)) x 为 undefined
      */
  }
}
