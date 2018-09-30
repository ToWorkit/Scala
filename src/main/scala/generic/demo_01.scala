package generic

/**
  * 协变：一个泛型类接收的泛型参数的参数的值可以是本身的类型或者是子类的类型
  * + T
  */

class demo_01 {}

// 动物
class Animal {}
// 子类 鸟
class Bird extends Animal

// 协变类 必须有 +
// 吃的动作
class Eats[+ T](t: T) {}

object demo_01 {
  def main(args: Array[String]): Unit = {
    // 麻雀吃东西
    var e1 = new Eats[Bird](new Bird)

    // 创建一个鸟吃东西的对象
    // Eats 必须是协变否则会报错
    // 协变后就可以完成将一个子类Bird 赋给 父类Animal
    var e2: Eats[Animal] = e1
  }
}
