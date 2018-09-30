package generic

/***
  * implicit 声明的函数参数为隐式参数，可以实现隐式转换
  */

class demo_04 {}

object demo_04 {
  def testPram(implicit name: String) = "value " + name

  // 定义一个隐式参数
  implicit val name: String = "隐式函数"

  /**
    * 使用隐式参数实现隐式的转换，定义一个方法，找到两个值中较小的那个值
    * order 隐式函数，使用Ordered作为 order 的值，表示该值可以排序，也可以进行比较
    */
  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) = if(a < b) a else b

  def main(args: Array[String]): Unit = {
    // 隐式传参
    /**
      * 会自动调用函数
      */
    println(testPram) // value 隐式函数
    println(testPram("Hello")) // value Hello

    println(smaller(1, 3)) // 1
  }
}
