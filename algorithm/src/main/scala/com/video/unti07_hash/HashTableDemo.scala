package com.video.unti07_hash

import util.control.Breaks._

object HashTableDemo {
  def main(args: Array[String]): Unit = {
    val emp_01 = new Emp(1, "A")
    val emp_02 = new Emp(2, "B")
    val emp_03 = new Emp(3, "C")
    val emp_04 = new Emp(4, "D")
    val emp_05 = new Emp(5, "E")

    val emp_01_02 = new Emp(1, "AA")
    val emp_01_03 = new Emp(1, "AAA")

    val hashTab = new HashTab(7)
    hashTab.add(emp_01)
    hashTab.add(emp_02)
    hashTab.add(emp_03)
    hashTab.add(emp_04)
    hashTab.add(emp_05)
    hashTab.add(emp_01_02)
    hashTab.add(emp_01_03)

    hashTab.list()
    hashTab.findEmpById(1)
    hashTab.findEmpById(0)
    hashTab.findEmpById(9)

  }
}

// 创建Emp类
class Emp(eId: Int, eName: String) {
  val id = eId
  var name = eName
  var next: Emp = null
}

// 创建EmpLinkedList
class EmpLinkedList {
  // 定义头指针，会直接指向一个Emp类
  var head: Emp = null

  // 添加雇员的方法
  // 假定，踢去你家雇员的id是自增的，即雇员分配的id总是从小到大的
  def add (emp: Emp): Unit = {
    // 如果是第一个雇员
    if (head == null) {
      head = emp
      return
    }
    // 不修改head，所以需要定义一个辅助值
    var cur = head
    breakable {
      while (true) {
        if (cur.next == null) {
          break()
        }
        cur = cur.next
      }
    }
    // 遍历完后cur指向了链表的最后
    cur.next = emp
  }

  // 遍历链表
  def list(i: Int): Unit = {
    if (head == null) {
      println(s"${i} 为空链表")
      return
    }

    // 定义辅助指针
    var cur = head
    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        // 输出Emp的信息
        printf(s"第${i}条链表 no = %d name = %s\n", cur.id, cur.name)
        cur = cur.next
      }
    }
  }

  // 有返回emp，没有则返回null
  def findEmpById(id: Int): Emp = {
    // 只能一个一个的遍历
    if (head == null) {
      printf("查找不到，空链表\n")
      return null
    }
    var cur = head
    breakable {
      while (true) {
        if (cur == null) {
          break()
        }
        if (cur.id == id) {
          break()
        }
        cur = cur.next
      }
    }
    return cur
  }
}

// hash
// 加val，size会变为HashTable的只读属性
class HashTab(val size: Int) {
  val empLinkedListArr: Array[EmpLinkedList] = new Array[EmpLinkedList](size)

  // 初始化 empLinkedListArr的各个元素, 否则会报 94 行 空指针 java.lang.NullPointerException
  for (i <- 0 until size) {
    empLinkedListArr(i) = new EmpLinkedList
  }

  // 决定放在哪条链表中
  def add (emp: Emp): Unit = {
    var empLinkedListNo = hashFun(emp.id)
    empLinkedListArr(empLinkedListNo).add(emp)
  }

  // 显示（遍历整个hash表）
  def list() = {
    for(i <- 0 until size) {
      // 将列表号传入list中
      empLinkedListArr(i).list(i)
    }
  }

  // hash表中才知道应该去哪里找
  def findEmpById(id: Int): Unit = {
    // 要和添加的hash算法一致
    var empLinkedListNo = hashFun(id)
    val emp = this.empLinkedListArr(empLinkedListNo).findEmpById(id)
    if (emp != null) {
      printf(s"在 $empLinkedListNo 链表中找到了 id $id name ${emp.name} \n")
    } else {
      printf("没有找到\n")
    }
  }

  // hash散列函数
  def hashFun(id: Int): Int = {
    id % size
  }
}
