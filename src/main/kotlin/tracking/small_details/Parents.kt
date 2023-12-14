package net.integr.tracking.small_details

import net.integr.tracking.Person

class Parents {
    private val parentList: MutableList<Person> = mutableListOf()

    fun add(parent: Person): Parents {
        parentList += parent
        return this
    }

    fun remove(parent: Person): Parents {
        parentList -= parent
        return this
    }

    fun get() = parentList
}
