package com.video.unit02_linkedlist

/**
  * 使用链表解决约瑟夫问题
  */
import scala.util.control.Breaks.{break, breakable}


object Josephu {
  def main(args: Array[String]): Unit = {
    // 创建
    val boyGame = new BoyGame
    boyGame.add(7)
    boyGame.showBoy()

    boyGame.countBoy(4, 3, 7)
  }
}

// 定义类(丢手帕游戏)
class Boy(bNo: Int) {
  var no: Int = bNo
  var next: Boy = null
}

// 核心类
class BoyGame {
  // 定义一个初始的头结点(避免first.next == null 报错)
  var first: Boy = new Boy(-1)

  // 添加(形成一个单向的环形链表)
  // nums -> 由多少个节点组成
  def add(nums: Int) = {
    if (nums < 1) {
      println("error")
    }
    // 在形成环形链表时，需要一个辅助指针
    var curBoy: Boy = null

    for (no <- 1 to nums) {
      // 根据标号创建节点
      val boy = new Boy(no)
      // 头结点
      if (no == 1) {
        first = boy
        // 形成一个环形的链表
        first.next = first
        curBoy = first
      } else {
        curBoy.next = boy
        boy.next = first
        // 移动辅助指针
        curBoy = boy
      }
    }
  }

  // 编写游戏方法
  /**
    * @param startNo 从第几个人开始数
    * @param countNum 数几次
    * @param nums 一共多少人
    */
  def countBoy(startNo: Int, countNum: Int, nums: Int): Unit = {
    // 对参数进行判断
    if (first.next == null || startNo < 1 || startNo > nums) {
      println("errorparams")
    }

    /**
      * 1、两个辅助指针，first，helper，将helper指向first前面
      * 2、将first移动到 startNo
      * 3、开始数 countNum 个数, 同时移动first和helper
      * 4、删除first指向的节点
      */
    var helper = first
    // 1
    breakable {
      while (true) {
        if (helper.next == first) {
          break()
        }
        helper = helper.next
      }
    }
    // 2
    for (i <- 0 until startNo - 1) {
      first = first.next
      helper = helper.next
    }

    // 3, 数到的节点移除，直到环形链表只有一个节点时结束
    breakable {
      while (true) {
        if (helper == first) {
          break()
        }

        for (i <- 0 until countNum - 1) {
          first = first.next
          helper = helper.next
        }

        // 输出移除的节点
        printf("移除的节点 %d \n", first.no)

        // 移除first指向的节点
        first = first.next
        helper.next = first
      }
    }

    // 最后只剩下的一个节点
    printf("late %d\n", first.no)
  }

  // 遍历单向的环形链表
  def showBoy() = {
    if (first == null) {
      println("空节点")
    }
    // 因为头结点始终不可以改变，所有需要借助辅助节点
    var curBoy = first

    breakable {
      while (true) {
        printf("编号 %d\n", curBoy.no)
        if (curBoy.next == first) {
          break()
        }
        // 还有节点则后移继续遍历
        curBoy = curBoy.next
      }
    }
  }
}

