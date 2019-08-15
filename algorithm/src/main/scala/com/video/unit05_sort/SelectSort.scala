package com.video.unit05_sort

/**
  * 选择排序，属于内部排序(将数据全部加载到内存)
  */
object SelectSort {
  def main(args: Array[String]): Unit = {
    var arr = Array(101, 34, 119, 1)
    selectSort(arr)
    println("-" * 20)


    // 找规律

    // 第一轮 (101, 34, 119, 1) => (1, 34, 119, 101)
    var min = arr(0)
    var minIndex = 0
    for (j <- 0 + 1 until arr.length) {
      if (min > arr(j)) {
        min = arr(j)
        minIndex = j
      }
    }
    // 判断是否需要覆盖重置(有min保存要覆盖的值了)
    if (minIndex != 0) {
      arr(minIndex) = arr(0)
      arr(0) = min
    }
    println("第一轮 " + arr.mkString(" "))

    // 第二轮 (1, 34, 119, 101) => (1, 34, 119, 101)
    min = arr(1)
    minIndex = 1
    for (j <- (1 + 1) until arr.length) {
      if (min > arr(j)) {
        min = arr(j)
        minIndex = j
      }
    }
    // 判断是否需要覆盖重置(有min保存要覆盖的值了)
    if (minIndex != 1) {
      arr(minIndex) = arr(1)
      arr(1) = min
    }
    println("第二轮 " + arr.mkString(" "))

    // 第三轮 (1, 34, 119, 101) => (1, 34, 101, 119)
    min = arr(2)
    minIndex = 2
    for (j <- (2 + 1) until arr.length) {
      if (min > arr(j)) {
        min = arr(j)
        minIndex = j
      }
    }
    // 判断是否需要覆盖重置(有min保存要覆盖的值了)
    if (minIndex != 2) {
      arr(minIndex) = arr(2)
      arr(2) = min
    }
    println("第三轮 " + arr.mkString(" "))

  }


  def selectSort(arr: Array[Int]) = {
    for (i <- 0 until arr.length - 1) {
      var min = arr(i)
      var minIndex = i
      for (j <- i + 1 until arr.length) {
        if (min > arr(j)) {
          min = arr(j)
          minIndex = j
        }
      }
      // 判断是否需要覆盖重置(有min保存要覆盖的值了)
      if (minIndex != i) {
        arr(minIndex) = arr(i)
        arr(i) = min
      }
//      println(s"第${i + 1}轮 ${arr.mkString(" ")}")
    }
  }
}
