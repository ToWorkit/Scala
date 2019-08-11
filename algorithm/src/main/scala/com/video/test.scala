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
  }
}
