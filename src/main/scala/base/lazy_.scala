package base

object lazy_ {
  def main(args: Array[String]): Unit = {
    def foo(a: Int): Unit = {
      println("foo执行")
      a
    }

    val a = foo(2) // foo执行

    // 使用时才会执行
    lazy val a1 = foo(2)
    a1 // foo执行
  }
}
