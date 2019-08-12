package com.video.unit02_linkedlist

/**
  * 单向链表
  * 链表是有序的列表，但是在内存中的存储并不一定是有序的
  */

import util.control.Breaks._

object LinkedListDemo {
  def main(args: Array[String]): Unit = {
    // 测试单向链表的添加及遍历
    val node_01 = new TestNode(1, "a", "A")
    val node_02 = new TestNode(2, "b", "B")
    val node_03 = new TestNode(4, "c", "C")
    val node_04 = new TestNode(3, "e", "E")
    val node_05 = new TestNode(0, "f", "F")

    // 創建一个单向链表
    val singleLinkedList = new LinkedList
/*    singleLinkedList.add(node_01)
    singleLinkedList.add(node_02)
    singleLinkedList.add(node_03)*/
    singleLinkedList.add2(node_01)
    singleLinkedList.add2(node_02)
    singleLinkedList.add2(node_03)
    singleLinkedList.add2(node_04)
    singleLinkedList.add2(node_05)
    singleLinkedList.list()
    val node_06 = new TestNode(3, "ee", "E$E")
    singleLinkedList.update(node_06)
    println("")
    singleLinkedList.list()
    println("")
    singleLinkedList.del(1)
    println("")
    singleLinkedList.list()
    singleLinkedList.del(4)
    println("")
    singleLinkedList.list()
  }
}

// 定义单向链表管理test数据
class LinkedList {
  // 先初始化一个头结点(头结点一般不会改变[始终指向头部])
  val head = new TestNode(0, "", "")

  // 删除节点
  // 1、不动head
  // 2、使用temp变量，删除的是temp的下一个节点(在比较的时候，始终比较的是temp.next的节点值)
  def del(no: Int) = {
    var temp = head
    // 标识是否有要删除节点
    var flag = false
    breakable {
      while (true) {
        if (temp.next == null) {
          break()
        }
        // 找到了
        if (temp.next.no == no) {
          flag = true
          break()
        }
        // 后移
        temp = temp.next
      }
    }
    // 可以删除
    if (flag) {
      // 删除(改变指向到要删除的下一个节点，会有垃圾回收自动处理没有引用的节点)
      temp.next = temp.next.next
    } else {
      printf("%d 不存在\n", no)
    }
  }

  // 修改节点的值, 根据no序号为前提进行修改
  def update(newTestNode: TestNode) = {
    if (head.next == null) {
      println("空链表")
//      return
    }
    // 先找到节点
    var temp = head.next
    var flag = false
    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        // 找到节点
        if (temp.no == newTestNode.no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    // 判断是否找到
    if (flag) {
      temp.name = newTestNode.name
      temp.nickname = newTestNode.nickname
    } else {
      printf("没有找到编号为 %d 的节点\n", newTestNode.no)
    }
  }

  // 添加节点
  // 第一种方式，直接添加到链表的尾部
  def add(testNode: TestNode) = {
    // 因为头结点不可以修改, 因此需要有一个临时节点作为辅助
    var temp = head
    // 找到链表的最后
    breakable {
      while (true) {
        // temp已经是链表的最后了
        if (temp.next == null) {
          break()
        }
        // 没有到最后就继续往下找
        temp = temp.next
      }
    }
    // 找到链表的尾部然后将数据挂载上去
    temp.next = testNode
  }

  // 第二种方式，添加时保证链表是有序的(根据序号)
  // 如果有序号存在则报错
  def add2(testNode: TestNode): Unit = {
    // 因为头结点不可以修改, 因此需要有一个临时节点作为辅助
    // 在找添加位置时，是将节点加入到temp的后面
    // 因此在比较时是将当前的节点和temp.next的节点进行比较
    var temp = head
    // 标记(判断序号是否存在)
    var flag = false
    breakable {
      while (true) {
        // temp已经是链表的最后了
        if (temp.next == null) {
          break()
        }
        // 找到位置，需要将当前节点加到temp后面
        if (temp.next.no > testNode.no) {
          break()
        } else if (temp.next.no == testNode.no) {
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      printf("%d 已存在\n", testNode.no)
    } else {
      // 注意顺序
      testNode.next = temp.next
      temp.next = testNode
    }
  }

  // 遍历单向链表
  def list() = {
    // 判断当前链表是否为空
    if (head.next == null) {
      println("空链表")
//      return
    }

    // 因为头结点不可以修改, 因此需要有一个临时节点作为辅助
    // 头结点的数据在遍历的时候并不关心，所有可以直接指向next
    var temp = head.next
    breakable {
      while (true) {
        // 判断是否到最后了,注意没有next
        if (temp == null) {
          break()
        }
        printf("结点信息 no = %d, name = %s, nickName = %s\n", temp.no, temp.name, temp.nickname)
        temp = temp.next
      }
    }
  }
}

// 先创建节点node
class TestNode(tNo: Int, tName: String, tNickName: String) {
  var no: Int = tNo
  var name: String = tName
  var nickname: String = tNickName
  // 默认为null
  var next: TestNode = null
}
