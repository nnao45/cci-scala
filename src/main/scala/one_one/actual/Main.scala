package one_one.actual

// 文字列内に含まれる文字がユニークか探す

object Main extends App {
  val input = io.StdIn.readLine
  def judge: Boolean = {
    input.foreach(e => {
      if (input.filter(a => a == e).length > 1) return false
    })
    true
  }

  println(if (judge) "YES" else "NO")
}
