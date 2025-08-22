package com.tayler.appvalutay

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform