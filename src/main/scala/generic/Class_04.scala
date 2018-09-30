package generic

import scala.reflect.ClassTag

class Class_04 {
  // 用于创建一个 Int 类型数组的 函数
  def mkIntArr(e: Int*) = Array[Int](e: _*)
  // 用于创建一个 String 类型数组的 函数
  def mkStrArr(e: String*) = Array[String](e: _*)
  // 泛型函数，可以创建Int或者String类型数组的函数
  def mkArr[T: ClassTag](e: T*) = Array[T](e: _*)
}

object Class_04 {
  def main(args: Array[String]): Unit = {
    val gc = new Class_04

    // Int
    println(gc.mkIntArr(1, 2, 3, 4, 5).mkString(" "))
    // String
    println(gc.mkStrArr("A", "B", "C").mkString(" "))

    // Int和String
    println(gc.mkArr(4, 2, 1).mkString(" "))
    println(gc.mkArr("B", "D").mkString(" "))
  }
}
