package com.hb.daggersampleapp.datasource

import com.hb.daggersampleapp.models.User
import javax.inject.Inject

class LocalDataSource @Inject constructor() {
    fun getUserData(): List<User> {
        return listOf(
            User(1, "John"),
            User(2, "Doe"),
            User(3, "Michael"),
            User(4, "Jackson")
        )
    }
}