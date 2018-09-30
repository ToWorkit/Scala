package generic

class Class_02 {
  private var content: Int = 10

  // 定义get和set方法
  def get(): Int = content
  def set(v: Int) = { content = v }
}

class Class_03 {
  private var name: String = "lp"

  // 定义get和set方法
  def get(): String = name
  def set(v: String) = { name = v }
}

// 泛型通用类，既可以操作Int，亦可以操作String
class Class[T] {
  // 定义一个代表所有类型的变量
  private var flag: T = _

  // 定义get和set方法
  def set(value: T) = { flag = value }
  def get() = { flag }
}

object Class {
  def main(args: Array[String]): Unit = {
    // Int
    var IntOp = new Class[Int]
    IntOp.set(20)
    println(IntOp.get())

    // String
    var StringOp = new Class[String]
    StringOp.set("World")
    println(StringOp.get())
  }
}

