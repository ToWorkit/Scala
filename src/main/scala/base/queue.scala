package base

import scala.collection.mutable

object queue {
  def main(args: Array[String]): Unit = {
     // 队列
    /**
      * 只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作
      */
    val q1 = mutable.Queue[Int](2, 3, 1)
    println(q1) // Queue(2, 3, 1)

    val q2 = new mutable.Queue[Int]()
    q2 ++= q1
    println(q2) // Queue(2, 3, 1)

    // 值
    println(q1(1)) // 3
    q1(0) = 9
    println(q1) // Queue(9, 3, 1)
    // 追加
    q1 += 20
    println(q1) // Queue(9, 3, 1, 20)
    q1 ++= List(5, 6, 4)
    println(q1) // Queue(9, 3, 1, 20, 5, 6, 4)

    // 按照进队列的顺序删除(先进先出)
    q1.dequeue()
    println(q1) // Queue(3, 1, 20, 5, 6, 4)
    // 添加元素(末尾追加)
    q1.enqueue(3, 2, 1)
    println(q1)
    // 返回队列的第一个元素
    println(q1.head)
    // 返回队列最后一个元素
    println(q1.last)
    // 返回除了第一个以为的元素
    println(q1.tail)
  }
}
