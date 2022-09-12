object Q3 extends App {
  val acc1 = Account("1", 1000.0)
  val acc2 = Account("2", 2000.0)

  print("Accounts Details : \n")
  println(acc1)
  println(acc2)

  println("\nTransfer Rs 500.00 to account 2")
  acc1.transfer(500.0, acc2)

  print("\nAfter transfering : \n")
  println(acc1)
  println(acc2)

}

case class Account(acc: String, bal: Double) {
  var accountNo = acc
  var balance = bal

  def withdraw(amount: Double) = balance = balance - amount

  def deposit(amount: Double) = balance = balance + amount

  def transfer(amount: Double, toAccount: Account) = {
    balance = balance - amount
    toAccount.balance = toAccount.balance + amount
  }

  def isNegativeBalance() = if (balance < 0) true else false

  def addInterest(depositRate: Double, overdraftRate: Double) = balance =
    balance * (1 + (if (isNegativeBalance()) overdraftRate else depositRate))

  override def toString = "\nAccount : " + accountNo + "\nBalance : " + balance
}
