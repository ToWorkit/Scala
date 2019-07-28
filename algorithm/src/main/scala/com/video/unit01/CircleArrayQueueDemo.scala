package com.video.unit01

/**
  * 环形队列
  */
object CircleArrayQueueDemo {
  def main(args: Array[String]): Unit = {

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
  def 
}