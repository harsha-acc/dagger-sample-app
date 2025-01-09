package com.hb.daggersampleapp.repository

import com.hb.daggersampleapp.datasource.LocalDataSource
import com.hb.daggersampleapp.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    fun getLocalUserData(): List<User> {
        return localDataSource.getUserData()
    }
}