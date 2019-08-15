package com.video.unit05_sort

import java.text.SimpleDateFormat
import java.util.Date


/**
  * 冒泡排序
  */
object BubbleSort {
  def main(args: Array[String]): Unit = {
    // 創建一個80000个随机数据的数组
    val random = new util.Random()
    var arr = new Array[Int](80000)
    for (i <- 0 until 80000) { // 循环的生成随机数
      arr(i) = random.nextInt(8000000) // 1 - 8000000 之间
    }

    // 归并排序开辟的临时空间
    val temp = new Array[Int](arr.length)

    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间 = " + date)
//    println(arr.mkString(" "))

    /**
      * 排序前时间 = 2019-08-14 22:20:48
      * 排序后时间 = 2019-08-14 22:21:13
      */
//    bubbleSort(arr)

    /**
      * 排序前时间 = 2019-08-15 00:40:33
      * 排序后时间 = 2019-08-15 00:40:39
      */
//      SelectSort.selectSort(arr)

    /**
      * 排序前时间 = 2019-08-15 22:39:50
      * 排序后时间 = 2019-08-15 22:39:52
      */
//    InsertSort.inserts(arr)

    /**
      * 排序前时间 = 2019-08-15 23:25:53
      * 排序后时间 = 2019-08-15 23:25:53
      */
//    QuickSort.quickSort(0, arr.length - 1, arr)



    /**
      * 排序前时间 = 2019-08-16 00:29:31
      * 排序后时间 = 2019-08-16 00:29:31
      * 和快速排序差不多
      *   都是先分再合
      */
    MergeSort.mergeSort(arr, 0, arr.length - 1, temp)

    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间 = " + date2)
//    println(arr.mkString(" "))
  }

  def bubbleSort(arr: Array[Int]) = {
    for (i <- 0 until arr.length - 1) {
      for (j <- 0 until arr.length - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
  }
}
