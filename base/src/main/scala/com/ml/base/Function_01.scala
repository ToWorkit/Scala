package com.ml.base

object Function_01 {
  /**
    * _ 在函数后面增加下划线，表示将函数当成类型赋值， 而不会执行
    *   闭包或者回调函数时使用，不加会报错
    * @param args
    */
  def main(args: Array[String]): Unit = {
    var fun2 = f2 _
    fun2()()
  }

  def f1() : Unit = {
    println("f1")
    // 写了 Unit 那么 return 会被忽略掉 Return keyword is redundant
    // return 1
  }

  /**
    * 不写返回值默认会将最后一行代码作为返回值
    */
  def f2() = {
    f1 _
  }
}
