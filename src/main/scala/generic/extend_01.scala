package generic


/**
  * 继承
  *   1、基本的继承
  *   2、复写父类中的方法
  *   3、使用匿名子类
  */
class extend_01 {}


// 定义父类
class Person(val name: String, val age: Int) {
  // 方法(函数)
  def sayHello(): String = "Hello " + name + " and the age is " + age
}

// 定义子类
class Emp(override val name: String, override val age: Int, sex: String) extends Person(name, age) {
  // 重写父类的方法
  override def sayHello(): String = "子类重写父类的方法 " + sex
}

object extend_01 {
  def main(args: Array[String]): Unit = {
    // 创建一个Person对象
    var p = new Person("Tom", 20)
    println(p.sayHello()) // Hello Tom and the age is 20

    // 创建一个子类
    var p1: Person = new Emp("Job", 25, "女")
    println(p1.sayHello()) // 子类重写父类的方法 女

    // 创建一个匿名子类，从 Person 继承
    var p2 = new Person("ml", 22) {
      // 匿名子类中重写方法
      override def sayHello(): String = "匿名子类中重写方法"
    }
    println(p2.sayHello()) // 匿名子类中重写方法
  }
}