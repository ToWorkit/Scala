package com.video.unit01_array

import scala.io.StdIn

/**
  * 环形队列
  */
object CircleArrayQueueDemo {
  def main(args: Array[String]): Unit = {
    // 初始化队列
    val queue = new CircleArrayQueue(4)
    var key = ""
    while (true) {
      /**
        * show 表示显示队列
        * exit 表示退出队列
        */
      key = StdIn.readLine()
      key match {
        case "show" => queue.showQueue()
        case "add" => {
          println("输入环形队列的数据")
          val value = StdIn.readInt()
          queue.addQueue(value)
        }
        case "get" => {
          // 处理 Any 类型的返回数据
          val res = queue.getQueue()
          // 如果是异常错误
          if (res.isInstanceOf[Exception]) {
            // 将 Any 类型转为异常
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            println(s"get $res")
          }
        }
        case "head" => {
          // 处理 Any 类型的返回数据
          val res = queue.headQueue()
          // 如果是异常错误
          if (res.isInstanceOf[Exception]) {
            // 将 Any 类型转为异常
            println(res.asInstanceOf[Exception].getMessage)
          } else {
            println(s"head $res")
          }
        }
        case "e" => System.exit(0)
      }
    }
  }
}


// 环形的队列
class CircleArrayQueue(arrMaxSize: Int) {
  val maxSize = arrMaxSize
  // 存放数据，模拟队列
  val arr = new Array[Int](maxSize)
  // 指向队列的头部
  var front = 0
  // 指向队列的尾部
  var rear = 0

  // 判断队列满的方法
  def isFull(): Boolean = {
    // 空出来一个(+1)作为预留[即长度为4的元素只能存储3个数据，空出来的一位用作环形操作的缓冲区]
    (rear + 1) % maxSize == front
  }

  // 判断队列为空的条件
  def isEmpty(): Boolean = {
    rear == front
  }

  // 添加数据
  def addQueue(n: Int): Unit = {
    // 判断队列是否是满的
    if (isFull()) {
      println("队列是满的")
      return
    }
    // 将数据加入
    arr(rear) = n
    // 然后将rear后移(需要rear是最后一位时，需要取模才能实现环形)
    rear = (rear + 1) % maxSize
  }

  // 获取数据(遵守先进先出的原则)
  def getQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列为空")
    }
    // 需要一直使front指向队列的头元素
    // 1、先把front对应的数据保存到变量
    var value = arr(front)
    // 2、将front后移(环形需要取模)
    front = (front + 1) % maxSize
    // 3、将前面保存的变量返回
    return value
  }

  // 显示队列的所有数据
  def showQueue(): Unit = {
    if (isEmpty()) {
      println("队列为空")
      return
    }
    // 从front开始取，取出多少个元素
    // 0 until 3 => 0, 1, 2
    for (i <- front until front + size()) {
      printf("arr[%d] = %d\n", i % maxSize, arr(i % maxSize))
    }
  }

  // 算出当前环形队列一共有多少个元素
  def size(): Int = {
    // rear = 1
    // front = 0
    // maxSize = 3
    (rear + maxSize - front) % maxSize
  }

  // 查看队列的头元素(仅查看不取数据)
  def headQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列为空")
    }
    // front直接指向的就是队列头部(第一个元素)
    return arr(front)
  }
}