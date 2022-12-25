package com.mityushovn.mobilebankmultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform