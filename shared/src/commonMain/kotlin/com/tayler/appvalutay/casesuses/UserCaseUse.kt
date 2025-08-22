package com.tayler.appvalutay.casesuses

import com.tayler.appvalutay.Platform
import com.tayler.appvalutay.casesuses.network.IUserRepository
import kotlin.let

/**
 * Simple presenter - use the HelloRepository to "say" hello
 */
class UserCaseUse(
    private val repository: IUserRepository,
    private val platform: Platform
) {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from ${platform.name}" } ?: "User '$name' not found!"
    }
}