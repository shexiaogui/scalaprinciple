package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c <= 0 || r <= 0 || c >= r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(rest: List[Char]): Boolean = {
    var opening = 0
    def loop(i: Int): Boolean = {
      if (i >= rest.length) opening == 0
      else if (rest(i) == ')' && opening == 0) false
      else if (rest(i) == '(') {
        opening += 1; loop(i + 1)
      }
      else if (rest(i) == ')' && opening != 0) {
        opening -= 1; loop(i + 1)
      }
      else loop(i + 1)
    }
    loop(0)

  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.length == 0) 0
        else if (money == 0) 1
        else countChange(money - coins.head,coins) + countChange(money, coins.tail)

      }
}