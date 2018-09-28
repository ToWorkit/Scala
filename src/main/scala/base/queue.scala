package base

import scala.collection.mutable

object queue {
  def main(args: Array[String]): Unit = {
     // 队列
    val q1 = mutable.Queue[Int](2, 3, 1)
    println(q1)

    val q2 = new mutable.Queue[Int]()
    q2 ++= q1

  }
}
