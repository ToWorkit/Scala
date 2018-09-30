package generic

class Class_01 {
  private var age: Int = 10
  private var content: String = "Hello World"
}

object Class_01 {
  def main(args: Array[String]): Unit = {
    val g = new Class_01
    println(g.age)
    g.age = 20
    println(g.age, g.content)
  }
}
