package com.video.unit05_sort

/**
  * 归并排序，分(并没有排序只是将数据打散)而治(合并排序)之
  *   代码需要两部分函数，一个分，一个合
  */
object MergeSort {
  def main(args: Array[String]): Unit = {
    var arr = Array(-9, 78, 0, 23, -567, 70)
    val temp = new Array[Int](arr.length)

    mergeSort(arr, 0, arr.length - 1, temp)
    println(arr.mkString(" "))
  }

  /**
    * @param arr  待排序的数组
    * @param left 最初的左边的下标 0
    * @param right  最初的右边的下标 length - 1
    * @param temp 临时数组，事先就开辟好空间，大小和arr一致
    */
  def mergeSort(arr: Array[Int], left: Int, right: Int, temp: Array[Int]): Unit = {
    // 分
    if (left < right) {
      val mid = (left + right) / 2
      // 递归将左边的数据做成有序列表
      mergeSort(arr, left, mid, temp)
      // 右边
      mergeSort(arr, mid + 1, right, temp)
      // 合
      merge(arr, left, mid, right, temp)
    }
  }

  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]): Unit = {
    // 左边的下标索引
    var i = left
    // 右边的第一个下标索引
    var j = mid + 1
    // temp临时数组的下标索引
    var t = 0
    //
    while (i <= mid && j <= right) {
      if (arr(i) <= arr(j)) { // 如果当前的左边的有序列表的值 小于 当前的右边的有序列表的值，则将这个值copy到temp中
        temp(t) = arr(i)
        t += 1
        i += 1
      } else { // 右边 小于 左边，将值copy到temp中
        temp(t) = arr(j)
        t += 1
        j += 1
      }
    }
    // 如果左边有序列表还有剩余的数据，就依次copy到temp数组中
    while (i <= mid) {
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    // 右边
    while (j <= right) {
      temp(t) = arr(j)
      t += 1
      j += 1
    }

    // 将 本次的temp 数据copy到原数组中去
    t = 0
    var tempLeft = left
    while (tempLeft <= right) {
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }
  }
}
