package com.mityushovn.mobilebankmultiplatform.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform