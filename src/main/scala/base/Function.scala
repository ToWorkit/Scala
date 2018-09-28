package base

object Function {
  def main(args: Array[String]): Unit = {
    /**
      * 不同的写法
      */
    def foo1(a: Int, b: Int): String = {
      String.valueOf(a + b)
    }
    // 3 class java.lang.String
    println(foo1(1, 2).getClass)

    def foo2(a: Int, b: Int) = {
      a + b
    }
    println(foo2(2, 3))

    def foo3(a: Int, b: Int) = a + b
    println(foo3(4, 5))

    // 默认值
    def foo4(a: Int = 10, b: Int = 1) = a + b
    println(foo4()) // 11
    println(foo4(1, 1)) // 2

    // 递归
    def factorial(n: Int): Int = {
      if (n == 1)
        n
      else
        factorial(n - 1) * n
    }
    println(factorial(5))

    // 递归尾调用优化
    def factorial_max(n: Int, res: Int = 1): Int = {
      if (n == 1)
        res
      else
        factorial_max(n - 1, res * n)
    }
    println(factorial_max(5))

    // 不定长多参数
    // 默认会把最后一行代码作为返回值
    def foo5(args: Int*) = {
      var sum = 0;
      for(i <- args) {
        sum += i
      }
      sum
    }
    println(foo5(1, 2, 3))

    // 匿名函数
    val foo6 = (a: Int, b: Int) => {
      a + b
      a - 4 + a - b
    }
    println(foo6(10, 2))
  }
}
