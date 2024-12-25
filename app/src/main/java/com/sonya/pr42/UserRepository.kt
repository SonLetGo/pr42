package com.sonya.pr42

object UserRepository {
    private val users = mutableListOf<User>()
    private var nextId = 1

    fun addUser(firstName: String, lastName: String) {
        users.add(User(id = nextId++, firstName = firstName, lastName = lastName))
    }

    fun getAllUsers(): List<User> {
        return users.toList()
    }
}
