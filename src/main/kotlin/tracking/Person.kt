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
}