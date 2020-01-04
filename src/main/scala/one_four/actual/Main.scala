package one_four.actual

// その文字列が並び替えれば回文可能な文字列かどうか
// Tact Coa
// bacd dcab
// tactcoapapa

object Main extends App {
  val input = io.StdIn.readLine.filter(_ != ' ').toLowerCase

  def isPermutationOfPalindrome(phrase: String): Boolean = {
    // 与えられた文字列からビットベクトルを作る
    val bitVector = crateBitVector(phrase)
    bitVector == 0 | checkExactlyOneBitSet(bitVector)
  }

  def crateBitVector(phrase: String): Int = {
    var bitVector = 0
    phrase.toCharArray.foreach(c => bitVector = toggle(bitVector, c.toInt))
    bitVector
  }

  def toggle(bitVector: Int, index: Int): Int = {
    if (index < 0) return bitVector

    val mask = 1 << index
    if ((bitVector & mask) == 0) {
      bitVector | mask
    } else {
      bitVector & ~mask
    }
  }

  def checkExactlyOneBitSet(bitVector: Int) = (bitVector & (bitVector - 1)) == 0

  println(if (isPermutationOfPalindrome(input)) "YES" else "NO")
}
