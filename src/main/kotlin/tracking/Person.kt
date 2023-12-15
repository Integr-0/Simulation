package net.integr.tracking

import net.integr.tracking.small_details.Gender
import net.integr.tracking.small_details.Parents
import net.integr.tracking.small_details.economy.Company
import net.integr.tracking.small_details.finances.BankAccount

class Person(
    val name: String,
    val gender: Gender,
    val parents: Parents
) {
    var age = 0
    private val jobs: MutableList<Company> = mutableListOf()
    private val bankAccounts: MutableList<BankAccount> = mutableListOf()
    private val children: MutableList<Person> = mutableListOf()

    private var salaryIndex = -1;
    var salary = 0

    fun addBankAccount(account: BankAccount): Person {
        bankAccounts += account
        return this
    }

    fun removeBankAccount(account: BankAccount): Person {
        bankAccounts -= account
        return this
    }

    fun addChildren(person: Person): Person {
        children += person
        return this
    }

    fun addJob(job: Company): Person {
        jobs += job
        return this
    }

    fun removeJob(job: Company): Person {
        jobs -= job
        return this
    }

    fun setSalaryIndex(index: Int): Person {
        salaryIndex = index
        return this
    }

    fun getBankAccounts() = bankAccounts
    fun getBankAccount(index: Int) = bankAccounts[index]
    fun getJobs() = jobs

    fun getSalaryAccount() = bankAccounts[salaryIndex]

    fun rob(person: Person, amount: Int) {
        if (person.bankAccounts.isNotEmpty()) {
            person.getBankAccount(0).pay(this.getBankAccount(0), amount)
        }
    }

    fun die() {
        var totalMoney = 0
        for (bankAccount in bankAccounts) {
            totalMoney += bankAccount.balance
        }

        val inheritanceMoney = totalMoney/children.count()

        for (child in children) {
            if (child.getBankAccounts().isNotEmpty()) {
                child.getBankAccount(0).balance += inheritanceMoney
            }
        }
    }
}