package base

object stream {
  /**
    * stream是一个集合。这个集合，可以用于存放，无穷多个元素，但是这无穷个元素并不会一次性生产出来，
    *   而是需要用到多大的区间，就会动态的生产，末尾元素遵循lazy规则。
    */
  def main(args: Array[String]): Unit = {
    // 使用#::得到一个stream
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n + 1)
    val num = numsForm(10)
    println(num) // Stream(10, ?)
    /**
      * 1、生成一个排除了首元素的新集合
      * 2、tail方法会触发stream的使用，会在调用.tail方法的stream上新增元素
      */
    println(num.tail) // Stream(11, ?)

    // 计算 5 * 5
    println(numsForm(5).map(x => x * x)) // Stream(25, ?)

    /**
      * Stream的懒执行行为，可以使用view方法来得到类似的效果，该方法产出一个其方法总是被懒执行的集合。但是view不会缓存数据，每次都要重新计算
      */
    // 找到100以内，所有数字倒序排列还是它本身的数字。
    val views = (1 to 100).view.map(x => x).filter(x => x.toString.reverse == x.toString)
    println(views.mkString(" "))
  }
}
