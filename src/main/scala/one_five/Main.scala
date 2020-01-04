package one_five

// 文字列に対して挿入、削除、置き換えが出来たとき
// 2つの文字列が与えられたとき、一方の文字列に対して１操作でもう一方の文字列に出来るか？
//
// ok // pale, ple
// ok // pales, pale
// ok // pale, bale
// ng // pale, bake
//


object Main extends App {
  val input = io.StdIn.readLine.split(' ')

  def judge(left: String, right: String): Boolean = {
    val leftCA = left.toCharArray.toSeq
    var rightCA = right.toCharArray.toSeq
    val subLR =  rightCA.length - leftCA.length
    if (subLR > 2) return false
    leftCA.foreach(c => {
      val index = rightCA.indexOf(c)
      if (index >= 0) {
        val (a, b) = rightCA.splitAt(index)
        rightCA = a ++ b.tail
      }
    })
    rightCA.length <= 1
  }

  val (left, right) = if (input(0).length < input(1).length) (input(0), input(1)) else (input(1), input(0))

  println(if (judge(left, right)) "YES" else "NO")
}
