package com.video.unit04_recursive

object MIGong {
  def main(args: Array[String]): Unit = {
    // 地图 8行 7列
    val map = Array.ofDim[Int](8, 7)
    // 上下的边框全部为1(行不变)
    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }
    // 左右的边框全部为1(列不变)
    for (i <- 1 until 7) {
      map(i)(0) = 1
      map(i)(6) = 1
    }

    // 设置挡板
    map(3)(1) = 1
    map(3)(2) = 1
    // 添加围墙(会跑不通路，可以注释)
    map(1)(2) = 1
    map(2)(2) = 1

    // 打印地图
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + " ")
      }
      println()
    }

    // 测试
    setWay(map, 1, 1)

    println(" " * 20)

    // 打印新地图
    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) + " ")
      }
      println()
    }


    /**
      * @param map  地图
      * @param i  j 指定从地图上的哪个点开始出发(1, 1)
      * @return 是否找到
      *         规则约定: 0 -> 可以走还没有走，1 -> 墙，2 -> 表示可以走， 3 -> 已经走过但是不通
      */
    // 使用递归回溯来找出所有的路径
    def setWay(map: Array[Array[Int]], i: Int, j: Int): Boolean = {
      if (map(6)(5) == 2) { // 表示路通了
        true
      } else {
       if (map(i)(j) == 0) { // 可以走还没走
         // 开始递归回溯
         map(i)(j) = 2 // 先假设该点是可以走通的
         // 判断 下 右 上 左是否可以走通
         if (setWay(map, i + 1, j)) { // 下
           true
         } else if (setWay(map, i, j + 1)) { // 右
           true
         } else if (setWay(map, i - 1, j)) { // 上
           true
         } else if (setWay(map, i, j - 1)) { // 左
           true
         } else {
           // 走不通
           map(i)(j) = 3
           false
         }
       } else { // 如果map(i)(j) != 0 则值 1/2/3
          false
       }
      }
    }
  }
}
