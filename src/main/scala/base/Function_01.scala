package base

// 高阶函数
// 全部引入
import scala.math._

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

    // 数值运算
    // math 大多运算返回 double 类型的值
    /**
      * 传入匿名函数方法对9进行运算
      * @param f (Double) => (Double) 匿名函数的参数(9)及返回值类型
      * @return
      */
    def someAction(f: (Double) => (Double)) = f(9)
    // 开平方
    println(someAction(sqrt))
    // 三角函数
    println(someAction(sin))

    // 函数作为参数多层运算
    def f4(x: Int, y: Int) = x * y + 100
    /**
      * 三个参数
      * @param f f: (Int, Int) => Int 匿名函数
      * @param x x: Int
      * @param y y: Int
      * @return 匿名函数的返回值
      */
    def f5(f: (Int, Int) => Int, x: Int, y: Int) = f(x, y)

    println(f5(f4, 2, 3)) // 106

    /**
      * 柯里化
      *   把具有多个参数的函数转换为一条函数链，每个节点上是单一参数
      */
    def f6(x: Int, y: Int) = x + y
    // 等价于 f6
    // 柯里化语法
    def f8(x: Int) = (y: Int) => x + y
    // 简化写法
    def f7(x: Int)(y: Int) = x + y
    println(f6(1, 2)) // 3
    println(f7(1)(2)) // 3
    println(f8(1)(2)) // 3

  }
}
