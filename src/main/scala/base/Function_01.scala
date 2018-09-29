package base

object Function_01 {
  def main(args: Array[String]): Unit = {
    def f1(name: String)= "Hello" + name
    def f2() = " World"

    // 将函数作为参数的值传递 -> 值函数
    println(f1(f2())) // Hello World

    /**
      * 闭包
      *   内函数中可以访问外函数的变量
      * factor
      *   接收一个double类型的参数，表示 多少倍
      * x
      *   x 匿名函数，作为内函数可以访问外函数的值即factor
      */
    def f3(factor: Double) = (x: Double) => x * factor
    // 对传入值乘以3的方法函数
    val foo = f3(3)
    println(foo(10)) // 30.0
  }
}
