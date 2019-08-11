package com.video.unit03_stack

/**
  * 栈
  * 先进后出
  */

object ArrayStackDemo {
  def main(args: Array[String]): Unit = {
    var arr = new ArrayStack(5)

    arr.push(1)
    arr.push(2)
    arr.push(3)
    arr.push(4)
    arr.push(5)
//    arr.push(6)

    arr.pop()
    arr.pop()
    arr.pop()
    arr.pop()
//    arr.pop()
//    arr.pop()

    arr.list()
  }
}

class ArrayStack(size: Int) {
  // 栈的大小
  val maxSize = size
  var stack = new Array[Int](maxSize)
  // 栈顶，初始化为-1
  var top = -1

  // 栈满
  def isFull(): Boolean = {
    top == maxSize - 1
  }

  // 栈空
  def isEmpty(): Boolean = {
    top == -1
  }

  // 入栈(添加数据)
  def push(value: Int) = {
    if (isFull()) {
      printf("栈满")
    }
    top += 1
    stack(top) = value
  }

  // 出栈(取出数据)
  def pop(): Any = {
    if (isEmpty()) {
      return new Exception("栈空")
    }
    val value = stack(top)
    top -= 1
    return value
  }

  // 遍历栈
  def list() = {
    if (isEmpty()) {
      println("栈空_list")
    }
    // 反向
    for (elem <- 0 to top reverse) {
      printf("stack[%d] = %d\n", elem, stack(elem))
    }
  }
}
