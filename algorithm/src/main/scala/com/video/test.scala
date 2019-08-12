package com.video

object test {
  def main(args: Array[String]): Unit = {
    // until(含头不含尾)
    // 0 - 2
    for (i <- 0 until 3) {
      println(i)
    }

    println("-" * 20)

    // to(有头有尾)
    // 0 - 3
    for (i <- 0 to 3) {
      println(i)
    }

    println("-" * 20)

    // reverse
    // 3 - 0
    for (i <- 0 to 3 reverse) {
      println(i)
    }
    println("-" * 20)

    /**
      * String
      * char
      */
    println("321".substring(0, 1).getClass.getSimpleName)
    println("321".substring(0, 1)(0).getClass.getSimpleName)
    // 1 String
    println("1".toInt)
    // 49 char -> ASCII值
    println("1"(0).toInt)
  }
}
