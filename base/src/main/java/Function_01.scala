object Function_01 {
  def main(args: Array[String]): Unit = {

    var v2 = f2 _ // 在函数的后面增加下划线，表示将函数当成类型赋值，而不会执行
    v2()()
  }

  def f1(): Unit = {
    println("f1")
  }

  // 会默认将最后一行代码作为返回值
  def f2()  = {
    f1 _
  }
}
