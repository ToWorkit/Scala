package generic

// 父类 抽象类
abstract class Person_02 {
  // 抽象字段
  var id: Int
  var name: String
}

// 一种做法
abstract class Employee1 extends Person_02 {
  var id: Int = 1
  var name: String = "No Name1"
}

// 另一种写法： 定义一个主构造器Employee2()，在主构造器中提供抽象字段
class Employee2(var id: Int) extends Person_02{
  // 只提供name
  var name: String = "No Name2"
}

object abstract_01 {
  def main(args: Array[String]): Unit = {
    var e1: Person_02 = new Employee1 {}
    println(e1.name) // No Name1
    println(e1.id) // 1
    var e2: Person_02 = new Employee2(24)
    println(e2.id) // 24
    println(e2.name) // No Name2
  }
}
