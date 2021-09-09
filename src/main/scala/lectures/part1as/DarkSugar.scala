package lectures.part1as

object DarkSugar extends App {


  val anUnImplementedInstance: UnImplemented = (a: String) => a.toInt

  abstract class UnImplemented {
    def implemented(x: Int): Int = x * 3

    def toImplement(in: String): Int
  }

  // ending with : are always right assosciative
}
