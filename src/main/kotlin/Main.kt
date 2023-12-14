package net.integr

import net.integr.tracking.Person
import net.integr.tracking.small_details.Gender
import net.integr.tracking.small_details.Parents
import net.integr.tracking.small_details.economy.Company
import net.integr.tracking.small_details.finances.BankAccount

fun main() {

    val willy = Person("Willy", Gender("MALE", "FEMALE"), Parents())
        .setSalaryIndex(0)

    val mary = Person("Mary", Gender("FEMALE", "MALE"), Parents())
        .setSalaryIndex(0)

    val lauren = Person("Lauren", Gender("FEMALE", "MALE"), Parents().add(willy).add(mary))
        .setSalaryIndex(0)

    val randomBank = Company("RandomBank", willy, 10)
        .addBankAccount(BankAccount(null, 100000))
        .addBankAccount(BankAccount(null, 70000))
        .addEmployee(lauren)
        .addEmployee(mary)

    willy.addBankAccount(BankAccount(randomBank, 100))
    lauren.addBankAccount(BankAccount(randomBank, 100))
    mary.addBankAccount(BankAccount(randomBank, 10))

    randomBank.getBankAccount(0).pay(lauren.getBankAccount(0), 100)
    randomBank.getBankAccount(1).pay(willy.getBankAccount(0), 1000)

    randomBank.paySalaries(0)

    println(lauren.getBankAccount(0).balance)
    println(willy.getBankAccount(0).balance)
}