package com.dz.tmdbmobileapi

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform