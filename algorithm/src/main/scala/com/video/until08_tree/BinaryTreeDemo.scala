package com.video.until08_tree

object BinaryTreeDemo {
  def main(args: Array[String]): Unit = {
    // 直接关联节点
    val root = new HeroNode(1, "A")
    val hero2 = new HeroNode(2, "B")
    val hero3 = new HeroNode(3, "C")
    val hero4 = new HeroNode(4, "D")
    val hero5 = new HeroNode(5, "E")

    root.left = hero2
    root.right = hero3

    hero3.left = hero5
    hero3.right = hero4

    val binaryTree = new BinaryTree
    binaryTree.root = root

//    binaryTree.preOrder()
//    binaryTree.infixOrder()
//    binaryTree.postOrder()

//    var resNode = binaryTree.preOrderSearch(2)
//    var resNode = binaryTree.infixOrderSearch(5)
    var resNode = binaryTree.postOrderSearch(5)
    if (resNode != null) {
      printf("编号 %d, name %s", resNode.no, resNode.name)
    } else {
      println("麽找到")
    }
  }
}

// 定义节点
class HeroNode(hNo: Int, hName: String) {
  val no = hNo
  var name = hName
  var left: HeroNode = null
  var right: HeroNode = null

  // 后序查找
  def postOrderSearch(no: Int): HeroNode  = {
    // 先向左递归查找
    var resNode: HeroNode = null
    if (this.left != null ) {
      resNode = this.left.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }

    // 向右递归查找
    if (this.right != null) {
      resNode = this.right.postOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }

    println("比较的次数")
    // 比较当前
    if (no == this.no) {
      return this
    }

    resNode
  }

  // 后序遍历(最后是父节点)
  def postOrder(): Unit = {
    // 向左递归输出左子树
    if (this.left != null) {
      this.left.postOrder()
    }
    // 向右递归输出右子树
    if (this.right != null) {
      this.right.postOrder()
    }
    // 先输出当前节点的值
    printf("no = %d name = %s\n", no, name)
  }

  // 中序查找
  def infixOrderSearch(no: Int): HeroNode  = {
    // 先向左递归查找
    var resNode: HeroNode = null
    if (this.left != null ) {
      resNode = this.left.infixOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }
    println("比较的次数")

    // 比较当前
    if (no == this.no) {
      return this
    }

    // 向右递归查找
    if (this.right != null) {
      resNode = this.right.infixOrderSearch(no)
    }

    return resNode
  }

  // 中序遍历(中间是父节点)
  def infixOrder(): Unit = {
    // 向左递归输出左子树
    if (this.left != null) {
      this.left.infixOrder()
    }
    // 先输出当前节点的值
    printf("no = %d name = %s\n", no, name)
    // 向右递归输出右子树
    if (this.right != null) {
      this.right.infixOrder()
    }
  }

  // 前序查找
  def preOrderSearch(no: Int): HeroNode = {
    // 先比较当前
    if (no == this.no) {
      return this
    }
    // 如果没找到
    // 向左递归查找
    var resNode: HeroNode = null
    if (this.left != null ) {
      resNode = this.left.preOrderSearch(no)
    }
    if (resNode != null) {
      return resNode
    }

    // 向右递归查找
    if (this.right != null) {
      resNode = this.right.preOrderSearch(no)
    }

    return resNode

  }

  // 前序遍历(先是父节点)
  def preOrder(): Unit = {
    // 先输出当前节点的值
    printf("no = %d name = %s\n", no, name)
    // 向左递归输出左子树
    if (this.left != null) {
      this.left.preOrder()
    }
    // 向右递归输出右子树
    if (this.right != null) {
      this.right.preOrder()
    }
  }
}

// 二叉树
class BinaryTree {
  var root: HeroNode = null

  // 后序查找
  def postOrderSearch(no: Int): HeroNode = {
    if (root != null) {
      root.postOrderSearch(no)
    } else {
      println("树为空")
      null
    }
  }

  // 后序遍历
  def postOrder(): Unit = {
    if (root != null) {
      root.postOrder()
    } else {
      printf("树为空")
    }
  }

  // 中序查找
  def infixOrderSearch(no: Int): HeroNode = {
    if (root != null) {
      return root.infixOrderSearch(no)
    } else {
      println("树为空")
      return null
    }
  }

  // 中序遍历
  def infixOrder(): Unit = {
    if (root != null) {
      root.infixOrder()
    } else {
      printf("树为空")
    }
  }

  // 前序查找
  def preOrderSearch(no: Int): HeroNode = {
    if (root != null) {
      return root.preOrderSearch(no)
    } else {
      println("树为空")
      return null
    }
  }


  // 前序遍历
  def preOrder(): Unit = {
    if (root != null) {
      root.preOrder()
    } else {
      printf("树为空")
    }
  }
}