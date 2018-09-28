package base

object list {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2)
    println(list(1)) // 2

    // 追加，结尾必须是一个空列表(Nil)或者列表
    val list2 = 1 :: 2 :: 3 :: Nil
    println(list2) // List(1, 2, 3)

    val list3 = 3 :: 4 :: List(1, 2)
    println(list3) // List(3, 4, 1, 2)

    val list4 = scala.collection.mutable.ListBuffer[Int]()
    list4.append(1, 2)
    println(list4) // ListBuffer(1, 2)
    // 不写 . 也行
    list4 update(0, 10)
    println(list4) // ListBuffer(10, 2)
  }
}
