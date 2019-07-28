package com.video.unit01_array

import scala.collection.mutable.ArrayBuffer

/**
  * 五子棋
  */
object SparseArr_01 {
  /**
    * 稀疏数组储存
    * @param args
    */
  def main(args: Array[String]): Unit = {
    val rowSize = 11
    val colSize = 11
    // 二维数组
    val chessMap = Array.ofDim[Int](rowSize, colSize)
    // 初始化棋盘
    chessMap(1)(2) = 1 // 黑棋
    chessMap(2)(3) = 2 // 白棋

    // 输出原始的地图
    for (item <- chessMap) {
      for (item2 <- item) {
        printf("%d\t", item2)
      }
      println()
    }

    // 将chessmap转为稀疏数组，达到对数据的压缩
    // class Node(row, col, value)
    // ArrayBuffer 存储
    val sparseArr = ArrayBuffer[Node]()
    // 存储原数组信息及有值的个数(从稀疏数组中取，先给个占位值)
    val node = new Node(rowSize, colSize, 0)
    sparseArr.append(node)
    for (i <- 0 until chessMap.length) {
      for (j <- 0 until chessMap(i).length) {
        // 存储不为0的值
        if (chessMap(i)(j) != 0) {
          // 构建一个 Node
          val node = new Node(i, j, chessMap(i)(j))
          // 添加到稀疏数组
          sparseArr.append(node)
        }
      }
    }
    // 输出稀疏数组
    for (node <- sparseArr) {
      printf("%d\t%d\t%d", node.row, node.col, node.value)
      println()
    }

    // 存盘

    // 读盘 -> 稀疏数组

    // 稀疏数组恢复到原始数组
    // 读取第一个节点
    val newNode = sparseArr(0)
    val rowSize_2 = newNode.row
    val colSize_2 = newNode.col

    val chessMap_2 = Array.ofDim[Int](rowSize_2, colSize_2)

    // 跳过第一个节点
    for (i <- 1 until sparseArr.length) {
      val node = sparseArr(i)
      chessMap_2(node.row)(node.col) = node.value
    }

    for(item <- chessMap_2) {
      for (item2 <- item) {
        printf("%d\t", item2)
      }
      println()
    }
  }
}

class Node(val row:Int, val col:Int, val value:Int)