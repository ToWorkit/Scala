package com.video.unit05_sort

/**
  * 插入排序，属于内部排序(将数据全部加载到内存)
  *   每次插入时都是有序的，直接覆盖值并没有交换，从无序列表中往有序列表里插值
  */
object InsertSort {
  def main(args: Array[String]): Unit = {
    var arr = Array(101, 34, 119, 1, 0, 200, -1, 0)
    inserts(arr)
    return

    // 第1轮插入排序
    // (101), 34, 119, 1 => (34, 101), 119, 1
    var insertVal = arr(1)
    // 表示有序列表中最后一个元素的下标
    var insertIndex = 1 - 1

    // 比有序列表中的最后一位数大，说明还没有找到插入的位置
    while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
      arr(insertIndex + 1) = arr(insertIndex)
      insertIndex -= 1
    }
    // 退出循环说明找到了要插入的位置
    arr(insertIndex + 1) = insertVal

    println("第一轮 " + arr.mkString(" "))

    // 第二轮
    // 34 101 119 1
    insertVal = arr(2)
    // 表示有序列表中最后一个元素的下标
    insertIndex = 2 - 1

    // 比有序列表中的最后一位数大，说明还没有找到插入的位置
    while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
      arr(insertIndex + 1) = arr(insertIndex)
      insertIndex -= 1
    }
    // 退出循环说明找到了要插入的位置
    arr(insertIndex + 1) = insertVal

    println("第二轮 " + arr.mkString(" "))

    // 第三轮
    // 1 34 101 119
    insertVal = arr(3)
    // 表示有序列表中最后一个元素的下标
    insertIndex = 3 - 1

    // 比有序列表中的最后一位数大，说明还没有找到插入的位置
    while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
      arr(insertIndex + 1) = arr(insertIndex)
      insertIndex -= 1
    }
    // 退出循环说明找到了要插入的位置
    arr(insertIndex + 1) = insertVal

    println("第三轮 " + arr.mkString(" "))
  }

  def inserts(arr: Array[Int]) = {
    for (i <- 1 until arr.length) {
      var insertVal = arr(i)
      // 表示有序列表中最后一个元素的下标
      var insertIndex = i - 1

      // 比有序列表中的最后一位数大，说明还没有找到插入的位置
      // 改动 insertVal > arr(insertIndex 从大到小
      while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
        arr(insertIndex + 1) = arr(insertIndex)
        insertIndex -= 1
      }
      // 退出循环说明找到了要插入的位置
      arr(insertIndex + 1) = insertVal
      println(s"第${i}轮 " + arr.mkString(" "))
    }
  }
}
