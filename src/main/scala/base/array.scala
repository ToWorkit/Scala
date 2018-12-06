package base

object array {
  def main(args: Array[String]): Unit = {
    // 定长数组
    val arr1 = new Array[Int](5)
    println(arr1.mkString(",")) // 0,0,0,0,0

    val arr2 = 1 +: arr1
    println(arr2.mkString(",")) // 1,0,0,0,0,0

    // 不定长数组
    import scala.collection.mutable.ArrayBuffer
    val arr3 = ArrayBuffer[Int]()
    // 添加元素
    arr3 += 1
    arr3 += 2
    // 添加多个
    arr3 += (3, 4, 5)
    // 去除后2个
    arr3.trimEnd(2)
    println(arr3) // ArrayBuffer(1, 2, 3)
    val arr4 = arr3 :+ 10
    println(arr4) // ArrayBuffer(1, 2, 3, 10)

    // 遍历数组
    arr3.foreach(print) // 无返回值
    println("")
    arr3.map(print) // 有返回值
    println("")

    var arr5 = Array(1, 20, 11, 9, 0, 4, 30)
    // 最值
    println(arr5.max, arr5.min, arr5.sum)

    // 排序(降序)
    // sortWith(_._2 > _._2) 降序
    println(arr5.sortWith(_  > _).mkString(" "))
    arr5.sortWith((x, y) => {
      if (x > y)
        true
      else
        false
    })

    // 二维数组
    val erArr = Array.ofDim[Int](3, 4)
    erArr(1)(3) = 30
    erArr.foreach(x => println(x.mkString(" ")))
  }
}
