object Q1 extends App {
  val obj1 = new Rational(1, 2)
  val obj2 = new Rational(4, 5)
  println(obj1.neg)
  val p = obj1.add(obj2)
  println(p)
}

class Rational(n: Int, d: Int) {
  require(denom > 0, "Denominator should be greater than 0")
  def numer = n
  def denom = d

  def add(r: Rational) = new Rational(
    this.numer * r.denom + this.denom * r.numer,
    this.denom * r.denom
  )
  def neg = new Rational(-this.numer, this.denom)
  override def toString(): String = numer + "/" + denom
}
