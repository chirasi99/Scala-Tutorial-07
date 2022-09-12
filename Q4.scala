object Q4 extends App {
  var accounts: List[Account] = List(
    Account("1", -1000.0),
    Account("2", 2000.0),
    Account("3", 3000.0)
  )

  print("\nAccounts balances with negative values: ")
  val negativeBalances = accounts.filter(account => account.isNegativeBalance())
  negativeBalances.map(account => println(account))

  print("\nThe total of all account balances : ")
  val tot =
    accounts.reduce((a, b) =>
      Account("-TOTAL of Accounts Balance -", a.balance + b.balance)
    )
  println(tot)

  print("\nFinal total of all accounts after paying the interest : ")
  accounts.map(account => account.addInterest(0.05, 0.1))
  accounts.map(account => println(account))
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
