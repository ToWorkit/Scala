package base

object exception {
  def main(args: Array[String]): Unit = {

  }

  def divider (x: Int, y: Int): Unit = {
    if (y == 0) throw new RuntimeException("0不可以做除数")
  }
}
