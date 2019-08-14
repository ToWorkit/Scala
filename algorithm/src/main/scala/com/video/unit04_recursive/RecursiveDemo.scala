package com.video.unit04_recursive

/**
  * 递归是先将前面的结果一个一个的压入栈中，递归结束后，再从栈顶开始一个一个的出栈
  */

object RecursiveDemo {
  def main(args: Array[String]): Unit = {
    test(4) // 2, 3, 4
  }

  def test(n: Int): Unit = {
    if (n > 2) {
      test(n - 1)
    }
    println(n)
  }
}
