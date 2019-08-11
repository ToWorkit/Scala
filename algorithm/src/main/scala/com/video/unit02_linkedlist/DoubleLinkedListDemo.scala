package com.video.unit02_linkedlist

import util.control.Breaks._

/**
  * 双向链表
  */

object DoubleLinkedListDemo {
  def main(args: Array[String]): Unit = {
    // 测试单向链表的添加及遍历
    val node_01 = new TestNode_02(1, "a", "A")
    val node_02 = new TestNode_02(2, "b", "B")
    val node_03 = new TestNode_02(4, "c", "C")
    val node_04 = new TestNode_02(3, "e", "E")
    val node_05 = new TestNode_02(1, "f", "F")

    // 創建一个链表
    val doubleLinkedList = new DoubleLinkedList
    doubleLinkedList.add(node_01)
    doubleLinkedList.add(node_02)
    doubleLinkedList.add(node_03)
    doubleLinkedList.add(node_04)

    // 显示
    doubleLinkedList.list()

//    doubleLinkedList.update(node_05)
//    doubleLinkedList.list()
//    println("-" * 10)
    doubleLinkedList.del(4)
    doubleLinkedList.del(2)
    doubleLinkedList.del(3)
    println("-" * 10)
    doubleLinkedList.list()

    // 最后节点少一步操作，会找出最后节点的线依旧存在，那么在添加的时候就会被激活，造成最后节点也会被一起添加进来
    doubleLinkedList.add(node_02)
    println("-" * 10)
    doubleLinkedList.list()

  }
}

/**
  * 双向链表管理数据
  */
class DoubleLinkedList {
  // 先初始化一个头结点(头结点一般不会改变[始终指向头部])
  val head = new TestNode_02(0, "", "")
  // 添加-遍历-修改-删除

  // 添加节点
  // 添加到链表的尾部
  def add(testNode: TestNode_02) = {
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
    // while循环之后，tmp就是链表的最后
    temp.next = testNode
    testNode.pre = temp
  }

  // 遍历双向链表
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


  // 修改节点的值, 根据no序号为前提进行修改
  def update(newTestNode: TestNode_02) = {
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


  // 删除节点
  // 1、因为双向链表可以实现自我删除
  def del(no: Int) = {
    // 判断列表不为空
    if(head.next == null) {
      println("链表为空")
    }

    var temp = head.next
    // 标识是否有要删除节点
    var flag = false
    breakable {
      while (true) {
        if (temp == null) {
          break()
        }
        // 找到了
        if (temp.no == no) {
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
      // temp即是要删除的节点
      // 改变前后指向
      temp.pre.next = temp.next
      if (temp.next != null) {
        // 只有当要删除的节点不是最后一个节点时才是用，最后一个节点不需要这样操作
        // 但是最后这条线会被保留，那么在添加节点的时候就会出现问题
        temp.next.pre = temp.pre
      }
    } else {
      printf("%d 不存在\n", no)
    }
  }

}


// 先创建节点node
class TestNode_02(tNo: Int, tName: String, tNickName: String) {
  // 序号
  var no: Int = tNo
  // 名称
  var name: String = tName
  // 昵称
  var nickname: String = tNickName
  // 指向前面的节点
  var pre: TestNode_02 = null
  // 指向后面的节点，默认为null
  var next: TestNode_02 = null
}
