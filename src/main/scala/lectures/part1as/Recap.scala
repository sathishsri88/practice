package lectures.part1as

import scala.annotation.tailrec

object Recap extends App {

  val aCondition: Boolean = false

  val aCodeBlock = {
    if (aCondition) {
      42
    }
    65
  }

  val theUnit: Unit = println("Hello Scala !!!")

  def recInt(x: Int): Int = x * 1

  @tailrec
  def factorial(n: Int, accumulator: Int): Int = {
    if (n <= 0) {
      accumulator
    }
    else {
      factorial(n - 1, n * accumulator)
    }
  }

  //OOPS
  class Animal
  class Dog extends Animal
  val aDog : Animal = new Dog // subtyping polymorphism

  trait Carnivore{
    def eat(a: Animal) : Unit
  }

  class Crocordile extends Animal with Carnivore {
    override def eat(a: Animal): Unit = {
      println("Crunch")
    }
  }

  //Method notations
  val aCroc = new Crocordile
  aCroc.eat(aDog)
  aCroc eat aDog // Natural language

  //Anonymous class
  val aCarnivore = new Carnivore {
    override def eat(a:  Animal): Unit = println("roar!")
  }

  //generics
  abstract class MyList[+A] // + is co variance

  //singletons and companions
  object MyList

  //Case classes
  case class Person(name:String, age : Int)

  //Exceptions and try/catch/finally
  val throwsNE = throw new RuntimeException // Nothing -> type of nothingness,  here type is nothing

  val aPotentialFailure: Unit = try {
    throwsNE
  } catch {
    case e : Exception => println(s"Caught exception $e")
  }finally {
    println("done logs")
  }

  // everything in Scala is a Object

  //packaging and imports

  //Functional programming
  val incrementer = new Function[Int,Int] {
    override def apply(v1:  Int): Int = v1+10
  }

  val funcResult: Int = incrementer(10)

  // first class support for functions

  val anonymousIncrementer = (x:Int) => x +1
  List(1,2,3).map(anonymousIncrementer) // Here MAP is a Higher order function[HOF]
  //HOF
  // Map, flatMap, filter

  //for comprehension
  val pairs = for{
    num <- List(1,2,3) if num >0
    char <- List('a','b','c')
  } yield num + "-"+ char

  // Scala collections : Seqs, Arrays,Lists, Vectors, Tuples
  val aMap = Map("Sathish" -> 42,
  "S"-> 53)

  //Collections : options, Try
  val anOption = Some(2)

  // Pattern matching
  val x = 2
  val order  = x match {
    case 1 => "First"
    case 2 => "Second"
    case 3 => "third"
  }

  val bob = Person("Bob",32)
  val greeting = bob match {
    case Person(name, _) => s"Hi, My name is $name"
  }

  //all patterns

}
