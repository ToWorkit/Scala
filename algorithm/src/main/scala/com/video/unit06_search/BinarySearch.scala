package com.video.unit06_search

import util.control.Breaks._

import scala.collection.mutable.ArrayBuffer

/**
  * 二分查找
  */
object BinarySearch {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 8, 8, 8, 10, 89, 1000, 8, 1234)
/*    val index = binarySearch(arr, 0, arr.length - 1, 12)
    println(index)*/


    val resArr = binarySearch_02(arr, 0, arr.length - 1, 8)
    println(resArr)
    if (resArr.length != 0) {
      for (index <- resArr) {
        println(index)
      }
    } else {
      println("-1")
    }
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


  /**
    * 如果查找中有多个相同的值
    * 1、返回结果为一个可变的数组
    * 2、找到结果后，向左向右扫描一遍
    * 3、再找到相同结果的索引时放入可变数组中
    */
  def binarySearch_02(arr: Array[Int], l: Int, r: Int, findVal: Int): ArrayBuffer[Int] = {

    // 没找到
    if (l > r) {
      ArrayBuffer[Int]()
    }

    // 中间索引
    val midIndex = (l + r) / 2
    // 中间值
    val midVal = arr(midIndex)

    if (midVal > findVal) { // 向左
      binarySearch_02(arr, l, midIndex - 1, findVal)
    } else if (midVal < findVal){ // 向右
      binarySearch_02(arr, midIndex + 1, r, findVal)
    } else {
      // 可变数组
      val resArr = ArrayBuffer[Int]()

      // 向左边扫描
      var temp = midIndex - 1
      breakable {
        while (true) {
          if (temp < 0) {
            break()
          }
          if (arr(temp) == findVal) {
            resArr.append(temp)
          }
          temp -= 1
        }
      }

      // 将中间索引加入
      resArr.append(midIndex)

      // 向右边扫描
      temp = midIndex + 1
      breakable {
        while (true) {
          if (temp > arr.length -1) {
            break()
          }
          if (arr(temp) == findVal) {
            resArr.append(temp)
          }
          temp += 1
        }
      }

      resArr
    }
  }
}
