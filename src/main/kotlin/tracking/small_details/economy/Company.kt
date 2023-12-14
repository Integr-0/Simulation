package net.integr.tracking.small_details.economy

import net.integr.tracking.Person
import net.integr.tracking.small_details.finances.BankAccount

class Company(val name: String, var owner: Person, var salary: Int) {
    private val employees: MutableList<Person> = mutableListOf()
    private val bankAccounts: MutableList<BankAccount> = mutableListOf()

    fun addEmployee(person: Person): Company {
        employees += person
        person.addJob(this)
        person.salary += salary
        return this
    }

    fun removeEmployee(person: Person): Company {
        employees -= person
        person.removeJob(this)
        person.salary -= salary
        return this
    }

    fun addBankAccount(account: BankAccount): Company {
        bankAccounts += account
        return this
    }

    fun removeBankAccount(account: BankAccount): Company {
        bankAccounts -= account
        return this
    }

    fun getEmployees() = employees
    fun getBankAccounts() = bankAccounts
    fun getBankAccount(index: Int) = bankAccounts[index]

    fun paySalaries(bankAccountIndex: Int) {
        for (employee in employees) {
            bankAccounts[bankAccountIndex].pay(employee.getSalaryAccount(), salary)
        }
    }
}