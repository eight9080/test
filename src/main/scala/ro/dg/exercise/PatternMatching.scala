package ro.dg.exercise

object PatternMatching  extends App {

  trait Expr
  case class Number(n:Int) extends Expr
  case class Sum(e1: Expr, e2:Expr) extends Expr
  case class Prod(e1: Expr, e2:Expr) extends Expr

  def compute(e: Expr): Int = {
    e match {
      case Number(n) => n
      case Sum(e1,e2) => compute(e1) + compute(e2)
      case Prod(e1,e2) => compute(e1) * compute(e2)
    }
  }

  println(compute(Sum(Number(2), Number(3))))
  println(compute(Prod(Sum(Number(2), Number(3)), Number(4))))


  def show (e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1,e2) => show(e1)+" + "+show(e2)
    case Prod(e1,e2) => {
      def maybeShowParentheses(expr: Expr) = expr match {
        case Prod(_,_) => show(expr)
        case Number(_) => show(expr)
        case _ => "("+show(expr)+")"
      }
      maybeShowParentheses(e1)+" * "+maybeShowParentheses(e2)
    }
  }
  println(show(Sum(Number(2), Number(3))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(4))))


}
