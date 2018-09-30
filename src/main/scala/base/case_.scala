package base

/**
  * 模式匹配
  */
object case_ {
  def main(args: Array[String]): Unit = {
    // 根据常量的值，匹配运算
    val ch = "-"
//    val ch = "-1"

    var num = 0
    // 匹配 ch
    ch match {
      case "+" => num += 1
      case "-" => num -= 2
      // 都没有匹配到
      case _ => num = 2
    }
    println(num) // -2
    // println(num) // 2


    /**
      * 守卫模式，匹配某种类型的所有值
      */
    // 匹配 数值类型
    var ch1 = 10

    var digit = 0
    ch1 match {
      case 1.0 => println(1.0)
      case 2 => println(2)
      // 是不是 Int类型的
      case _ if ch1.isInstanceOf[Int] => digit += 1
      case _ => println("emmm")
    }
    println(digit) // 1

    // 模式匹配中使用变量
    val ch2 = "Hello World"

    // char 类型
    ch2(2) match {
      case 'e' => println('e')
      case str => println("字符是 " + str) // 字符是 l
    }

    // 类型匹配
    // Any 表示任意类型(由值决定)
    var c5: Any = 100
    c5 match {
      case x: Int => println("整数") // 整数
      case x: String => println("字符串")
      case _ => println("其他类型")
    }

    // 数组和列表的长度
    var myArr = Array(1, 2, 3)
    myArr match {
      case Array(0) => println("0")
      case Array(x, y) => println("该数组中包含两个元素，和为： " + ( x + y))
      case Array(x, y, z) => println("该数组中包含三个元素，和为：" + (x + y + z))
      // _* 任意多
      case Array(_*) => println("这是一个数组")
    }

    var myList = List(1, 2, 3)
    myList match {
      case List(0) => println("0")
      case List(x, y) => println("该List中包含两个元素，和是：" + (x + y))
      case List(x, y, z) => println("该List中包含三个元素，和是: " + (x + y + z))
      case List(_*) => println("這是一個List")
    }
  }
}
