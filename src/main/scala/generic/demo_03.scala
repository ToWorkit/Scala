package generic

class demo_03 {}

// 水果
class Fruit(name: String) {
  def getFruitName(): String = name
}
// 猴子
class Monkey(f: Fruit) {
  def say() = println("Monkey like " + f.getFruitName())
}

object demo_03 {
  /**
    * 需求
    *   可以直接调用
    *     f = new Fruit()
    *     f.say()
    *   将 Fruit 对象转换成 Monkey 对象
    */
  // 定义一个隐式转换函数(规则), 将Fruit对象转为Monkey对象
  implicit def fruit2Monkey(f: Fruit) = new Monkey(f)

  def main(args: Array[String]): Unit = {
    val f1 = new Fruit("香蕉")
    f1.say() // Monkey like 香蕉
  }

}