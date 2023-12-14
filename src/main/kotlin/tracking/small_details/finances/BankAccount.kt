package net.integr.tracking.small_details.finances

import net.integr.tracking.small_details.economy.Company

class BankAccount(val company: Company?, var balance: Int = 0) {
    fun pay(account: BankAccount, amount: Int) {
        balance -= amount
        account.balance += amount
    }
}