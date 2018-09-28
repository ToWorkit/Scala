package base

import scala.collection.mutable

object set {
  def main(args: Array[String]): Unit = {

    /**
      * Set 值不会重复
      */

    // 不可变
    val s1 = Set(1, 2, 1, 2, 3, 4)
    println(s1)
    val s2 = mutable.Set(1, 2, 1, 2, 3, 4)
    println(s2)

    // 值
    println(s2(0))


  }
}
