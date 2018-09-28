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

    // 判断有木有
    println(s1(5))

    // 追加值
    s2.add(9)
    println(s2)

    s2 += 0
    s2.remove(2)
    s2 -= 1
    println(s2)

    for (x <- s2) {
      println(x)
    }

  }
}
