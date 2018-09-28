package base

object tuple {
  def main(args: Array[String]): Unit = {
    var t1 = (1, 2, 3, "lp")

    // 4 -> 个数
    val t2 = new Tuple4("Hello", 2, 1, 2.9)

    // 取值(1开始)
    println(t2._1) // Hello
    println(t2._4) // 2.9

    // 遍历，首先构造迭代器
    t2.productIterator.foreach(x => print(x + " ")) // Hello 2 1 2.9
  }
}
