package com.video.unit03_stack
import util.control.Breaks._

/**
  * 栈实现计算器
  */
object Calculator {
  def main(args: Array[String]): Unit = {
    /**
      * 1、设计两个站，数栈，符号栈
      * 2、扫描expression一个一个的取出
      * 3、当取出的字符是数字时，入数栈
      * 4、取出是符号时
      * 5、符号栈没有数据，直接入符号栈，如果当前符号的优先级小于或等于符号栈栈顶的符号优先级，则取出该符号，并从数栈中依次
      * pop出两个数据进行运算，将结果重新push到数栈，再将当前符号push到符号栈
      * 6、反之，符号直接入符号栈
      * 7、当整个表达式扫描完毕后，依次从数栈和符号栈取出数据，进行运算，最后在数栈中的数据就是最终的结果
      */
    var numStack = new ArrayStack_02(10)
    val operStack = new ArrayStack_02(10)
    // 单位数
//    val expression = "3+5*6-2"

    // 多位数
    val expression = "3001+5*6-2"
    var index = 0
    var num1 = 0
    var num2 = 0
    var oper = 0
    var res = 0
    var ch = ' '
    // 处理多位数(再次进行扫描时，保存上次的数组ch，并进行拼接)
    var keepNum = ""
    breakable {
      // 循环取出expression中的字符
      while (true) {
        // 含头不含尾 (0) => String -> char
        ch = expression.substring(index, index + 1)(0)
        // 如果是操作符
        if (operStack.isOper(ch)) {
          if (!operStack.isEmpty()) {
            // 判断优先级(当前符号和栈顶符号)
            if (operStack.priority(ch) <= operStack.priority(operStack.stack(operStack.top))) {
              // 开始计算
              num1 = numStack.pop().toString.toInt
              num2 = numStack.pop().toString.toInt
              oper = operStack.pop().toString.toInt
              res = numStack.cal(num1, num2, oper)
              // 结果入数栈
              numStack.push(res)
              // 还需要将ch入符号栈
              operStack.push(ch)
            } else {
              // 如果当前符号优先级大于栈顶的优先级,则直接入栈
              operStack.push(ch)
            }
          } else {
            // 为空直接入栈
            // ASCII '+' => 43
            operStack.push(ch)
          }
        } else {
          // 处理多位数
          // 拼接
          keepNum += ch

          // 如果ch是最后一个字符直接入栈
          if (index == expression.length - 1) {
            numStack.push(keepNum.toInt)
          } else {
            // 判断ch的下一个字符是数字还是字符，数字继续扫描，操作符符入栈
            // 看到expresson的下一个字符时，不要真正的移动index，只是看一下,用来判断是运算符还是数值
            if (operStack.isOper(expression.substring(index + 1, index + 2)(0))) {
              // 是操作符直接入栈
              numStack.push(keepNum.toInt)
              keepNum = ""
            }
          }

          // 需要将char 转为 String，因为char转int是ASCII值
//          numStack.push((ch + "").toInt)
        }

        // 后移 index
        index += 1
        // 判断时候遍历完成
        if (index >= expression.length()) {
          break()
        }
      }
    }

    breakable {
      // 取出栈的数据进行运算
      while (true) {
        if (operStack.isEmpty()) {
          break()
        }
        // 开始计算
        num1 = numStack.pop().toString.toInt
        num2 = numStack.pop().toString.toInt
        oper = operStack.pop().toString.toInt
        res = numStack.cal(num1, num2, oper)
        // 放入数栈
        numStack.push(res)
      }
    }
    val res_late = numStack.pop()
    printf("结果 %s = %d", expression, res_late)
  }
}

// 栈
class ArrayStack_02(size: Int) {
  // 栈的大小
  val maxSize = size
  var stack = new Array[Int](maxSize)
  // 栈顶，初始化为-1
  var top = -1

  // 栈满
  def isFull(): Boolean = {
    top == maxSize - 1
  }

  // 栈空
  def isEmpty(): Boolean = {
    top == -1
  }

  // 入栈(添加数据)
  def push(value: Int) = {
    if (isFull()) {
      printf("栈满")
    }
    top += 1
    stack(top) = value
  }

  // 出栈(取出数据)
  def pop(): Any = {
    if (isEmpty()) {
      return new Exception("栈空")
    }
    val value = stack(top)
    top -= 1
    return value
  }

  // 遍历栈
  def list() = {
    if (isEmpty()) {
      println("栈空_list")
    }
    // 反向
    for (elem <- 0 to top reverse) {
      printf("stack[%d] = %d\n", elem, stack(elem))
    }
  }

  // 判断是否是操作符
  def isOper(value: Int): Boolean = {
    value == '+' || value == '-' || value == '/' || value == '*'
  }

  // 优先级
  // 返回运算符的优先级，数字越大，优先级越高
  // + - => 0
  // * / => 1
  def priority(oper: Int): Int = {
    if (oper == '*' || oper == '/') {
      1
    } else if (oper == '+' || oper == '-') {
      0
    } else {
      -1
    }
  }

  // 计算方法
  def cal(num1: Int, num2: Int, oper: Int): Int = {
    var res = 0
    // ASCII 码值
    oper match {
      case '+' => {
        res = num1 + num2
      }
      case '-' => {
        // 注意顺序
        res = num2 - num1
      }
      case '*' => {
        res = num1 * num2
      }
      case '/' => {
        res = num2 / num1
      }
    }
    res
  }
}
