package generic

/**
  * 逆变，泛型类型接收的泛型参数的值可以是本身的类型或者其父类
  * - T
  */
class demo_02 {}

// 动物
class Animal_01 {}

// 子类 鸟
class Bird_01 extends Animal_01

// 子类 麻雀
class Sparrow extends Bird_01

// 定义吃东西的类 逆变
class EatSomething[- T](t: T) {}

object demo_02 {
  def main(args: Array[String]): Unit = {
    // 创建一个鸟吃东西的对象
    var c1: EatSomething[Bird_01] = new EatSomething[Bird_01](new Bird_01)
    // 创建一个麻雀吃东西的对象
//    var c2: EatSomething[Sparrow] = new EatSomething[Sparrow](new Sparrow)
    //  c1(父类) 赋值给 c2
    var c2:EatSomething[Sparrow] = c1
  }
}
