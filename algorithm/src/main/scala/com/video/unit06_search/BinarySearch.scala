package com.video.unit06_search

/**
  * 二分查找
  */
object BinarySearch {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 8, 10, 89, 1000, 1234)
    val index = binarySearch(arr, 0, arr.length - 1, 12)
    println(index)
  }

  // 如果存在就返回对应的下标，否则返回 -1
  /**
    * 1、先找到中间值
    * 2、然后将中间值和查找值比较
    * 2.1 相等则找出
    * 2.2 中间值 < 查找值，向左进行递归查找
    * 2.3 中间值 > 查找值，向右进行递归查找
    * 如果存在值则返回对应的下标，没有则为-1
    */
  def binarySearch(arr: Array[Int], l: Int, r: Int, findVal: Int):Int = {

    // 没找到
    if (l > r) {
      return -1
    }

    // 中间索引
    val midIndex = (l + r) / 2
    // 中间值
    val midVal = arr(midIndex)

    if (midVal > findVal) { // 向左
      binarySearch(arr, l, midIndex - 1, findVal)
    } else if (midVal < findVal){ // 向右
      binarySearch(arr, midIndex + 1, r, findVal)
    } else {
      midIndex
    }
  }
}
