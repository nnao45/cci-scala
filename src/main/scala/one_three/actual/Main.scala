package one_three.actual

// スペースを%20に変換

object Main extends App {
  val input = io.StdIn.readLine
  val result = input.toCharArray.map(i => if (i == ' ') "%20" else i.toString)
  print(result.mkString)
}
