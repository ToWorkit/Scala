package com.video.unit05_sort
import util.control.Breaks._
/**
  * 快速排序
  *   冒泡排序的改进版，以一个数为基准(大多以中间的数字)分为两部分，比基准小的一部分，大的一部分，
  *   然后进行递归对两个部分继续找一个基准数进行分割，最后全部分割到不可再分则排序结束
  */
object QuickSort {
  def main(args: Array[String]): Unit = {
    var arr = Array(-9, 78, 0, 23, -567, 70)
    quickSort(0, arr.length - 1, arr)
    println(arr.mkString(" "))
  }

  /**
    * @param left 数组坐标的下标 0
    * @param right  数组右边的下标 length - 1
    * @param arr  进行排序的数组
    */
  def quickSort(left: Int, right: Int, arr: Array[Int]): Any = {
    var l = left
    var r = right
    // 基准值
    var pivot = arr((left + right) / 2)
    var temp = 0
    breakable {
      // 进行交换，比基准值大的一部分(右)，小的一部分(左)
      while (l < r) {
        // 从左边找一个比基准值大的值对应的下标
        while (arr(l) < pivot) {
          l += 1
        }
        // 从右边找一个比基准值小的值对应的下标
        while (arr(r) > pivot) {
          r -= 1
        }
        // 本次递归交换结束，退出本次while
        if (l >= r) {
          break()
        }
        // 进行交换
        // 11, 10, 9, 1, -1 => -1, 10, 9, 1, 11
        var temp = arr(l)
        arr(l) = arr(r)
        arr(r) = temp

        // 遇到左边有值和基准值相等的数值就直接移动右边的下标，不参与比较交换，提高效率
        if (arr(l) == pivot) {
          r -= 1
        }
        if (arr(r) == pivot) {
          l += 1
        }
      }
    }

    // 避免自己跟自己比较(同样是提高效率)
    if (l == r) {
      l += 1
      r -= 1
    }

    // 向左进行递归排序(继续寻找基准值进行划分比较排序)
    if (left < r) {
      quickSort(left, r, arr)
    }
    if (right > l) {
      quickSort(l, right, arr)
    }
  }
}
