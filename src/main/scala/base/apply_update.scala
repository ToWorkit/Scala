package base

import scala.math._

object apply_update {
  def main(args: Array[String]): Unit = {
    // 开平方
    println(sqrt(100))

    val a = 10
    var b = 20

    /**
      * 任何数据都是对象
      * a 调用 + 方法 传入参数 b
      */
    println( a.+(b) )

    // 最大值
    println(1 max 9)

    // 静态方法(没有静态方法的概念，需要使用伴生类对象来实现)
    // 按指定位数取随机数，10指定的是二进制的位数，2 ^ 10 = 1024 随机数上限为1024
    println(BigInt.probablePrime(10, scala.util.Random))

    // 非静态方法
    println("Hello".charAt(1)) // e
    println("Hello".distinct) // 去重 Helo

    /**
      * apply
      *   "Hello"(2) 等同于 "Hello".apply(2)
      *   Array(1, 2, 3) 等同于 Array.apply(1, 2, 3)
      * update
      *   array(4) = 5 等同于 arr.update(4, 5)
      */

    println("Word"(2), "Word".apply(2)) // r, r

    val arr = new Array[Int](5)
    arr.foreach(print)
    println("")
    arr(1) = 2
    arr.foreach(print)
    arr.update(1, 3)
    println("")
    arr.foreach(print)
    println("")

    val map1 = Map("name" -> "lp", "age" -> "20")
    println(map1("name"))
    println(map1.get("age"))

    val arr1 = Array(1, 2, 3)
    println(arr1(0))
    println(arr1.mkString("|"))
  }
}
