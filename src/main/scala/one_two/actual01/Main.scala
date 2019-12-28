package one_two.actual01

object Main extends App {
  val input = io.StdIn.readLine.split(" ")
  val inputA = input(0)
  val inputB = input(1)

  def judge(left: String, right: String): Boolean = {
    if (left.length != right.length) return false
    if (left.toSeq.sortBy(identity) == right.toSeq.sortBy(identity)) true else false
  }

  println(if (judge(inputA, inputB)) "YES" else "NO")
}
