package com.video.unit01

/**
  * 单向队列
  * BUG代码，非环形队列(数据空间不能复用[只可以存储和获取一轮数据])
  */

import scala.io.StdIn

object ArrayQueueDemo {
  def main(args: Array[String]): Unit = {
    // 初始化队列
    val queue = new ArrayQueue(3)
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
          println("输入数据")
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

/**
  * 使用数组模拟队列
  * @param arrMaxSize 最大长度
  */
class ArrayQueue(arrMaxSize: Int) {
  val maxSize = arrMaxSize
  // 存放数据，模拟队列
  val arr = new Array[Int](maxSize)
  // 指向队列的头部，指向队列数据的前一个位置(需要+1)
  var front = -1
  // 指向队列的尾部，指向队列的最后一个数据(包含最后一位数据)
  var rear = -1

  // 判断队列是否是满的
  def isFull(): Boolean = {
    rear == maxSize - 1
  }
  // 判断队列是否为空
  def isEmpty(): Boolean = {
    front == rear
  }

  // 添加数据
  def addQueue(n: Int): Unit = {
    // 判断队列是否是满的
    if (isFull()) {
      println("队列是满的")
      return
    }
    // 先更新rear，后移(加从尾部加)
    rear += 1
    // 添加数据
    arr(rear) = n
  }

  // 获取数据
  def getQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列为空")
    }
    // 先移动front，后移(取从前面取)
    front += 1
    return arr(front)
  }

  // 显示队列的所有数据
  def showQueue(): Unit = {
    if (isEmpty()) {
      println("队列为空")
      return
    }
    for (i <- front + 1 to rear) {
      printf("arr[%d] = %d\n", i, arr(i))
    }
  }

  // 查看队列的头元素(仅查看不取数据)
  def headQueue(): Any = {
    if (isEmpty()) {
      return new Exception("队列为空")
    }
    // 只是查看不改变front的值
    return arr(front + 1)
  }
}
