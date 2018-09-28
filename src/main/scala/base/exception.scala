package base

object exception {
  def main(args: Array[String]): Unit = {
    try {
      divider(10, 0);
    } catch {
      case ex: RuntimeException => println("异常 " + ex.getMessage)
    } finally {}
  }

  def divider (x: Int, y: Int): Unit = {
    if (y == 0) throw new RuntimeException("0不可以做除数")
    else
      x / y
  }
}
