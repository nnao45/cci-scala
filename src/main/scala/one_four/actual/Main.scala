package one_four.actual

// その文字列が並び替えれば回文可能な文字列かどうか
// Tact Coa
// bacd dcab
// tactcoapapa

object Main extends App {
  val input = io.StdIn.readLine.filter(_ != ' ').toLowerCase
  var chars = Seq.fill(128)(0)

  def judge: Boolean = {
    input.toCharArray.foreach(c => {
      val index = c.toInt
      val value = chars(index)
      chars = chars.updated(index, value + 1)
    })
    if (chars.count(i => i != 0 && i % 2 != 0) > 1) false else true
  }

  println(if (judge) "YES" else "NO")
}
