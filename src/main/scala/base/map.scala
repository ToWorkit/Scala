package base

import scala.collection.mutable

object map {
  def main(args: Array[String]): Unit = {
    // 不可变(有序)
    val m1 = Map("name" -> "lp", "age" -> 22, "height" -> 1.80)
    println(m1)
    // 可变(无序)
    val m2 = mutable.Map("name" -> "lp", "age" -> 22, "height" -> 1.80)
    println(m2)

    // 值
    println(m2("age"))
    println(m2.updated("age", 11)) // Map(name -> lp, age -> 11, height -> 1.8)
    println(m2) // Map(name -> lp, age -> 20, height -> 1.8)

    // Error:(19, 5) value update is not a member of scala.collection.immutable.Map[String,Any] m1("sex") = "女"
/*    m1("sex") = "女"
    println(m1)*/

    m2("sex") = "男"
    println(m2)

    // 追加
    m2 += ("love" -> "女")
    println(m2)

    // 遍历
    for (i <- m2) {
      println(i)
    }

    for ((k, v)  <- m2) {
      println(k + " " + v)
    }

    // 判断某个值是否存在
    if (m2.contains("name")) {
      m2("name") = "pl"
    } else {
      -1
    }
    println(m2)
    // 简写
    val status = m2.getOrElse("weight", -1)
    println(status)
  }
}
