package base

object for_ {
  def main(args: Array[String]): Unit = {
      // 从后往前跑
/*    for (i <- 1 to 3; j <- 1 to 3; m <- 1 to 3) {
      print(i + "--" + j + "--" + m)
      println("")
    }*/
    // 10 - 19
    println(Range(10, 20)) // Range(10, 11, 12, 13, 14, 15, 16, 17, 18, 19)

    // 10 - 1
    for (i <- Range(10, 0, -1)) {
      print(i + " ")
    }
    println("")

    // 1 - 10
    // to左右两边为前闭后闭
    for (i <- 1 to 10) {
      print(i + " ")
    }
    println("")

    // 1 - 9
    // until左右两边为前闭后开
    for (i <- 1 until 10) {
      print(i + " ")
    }
    println("")

    // 偶数
    for (i <- 1 to 10 if i % 2 == 0) {
      print(i + " ")
    }
    println("")

    // 将结果都保存到一个集合中
    val res = for (i <- 1 to 5) yield i
    println(res)

    // {}
    for {
      i <- 1 to 3
      m = i * 2
    } println(m) // 2 4 6

    val list = List("Hello", "World", "Only")
    val upItem = for {
      item <- list
      upItem = item.toUpperCase
    }yield (upItem)
    println(upItem)
  }
}
