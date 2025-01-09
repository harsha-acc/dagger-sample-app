package com.hb.daggersampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hb.daggersampleapp.di.DaggerAppComponent
import com.hb.daggersampleapp.models.User
import com.hb.daggersampleapp.repository.UserRepository
import com.hb.daggersampleapp.ui.theme.DaggerSampleAppTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DI
        val appComponent = DaggerAppComponent.builder().build()
        appComponent.inject(this)

        // get dummy data
        val dummyUsers = userRepository.getLocalUserData()

        // render UI
        enableEdgeToEdge()
        setContent {
            DaggerSampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserListComposable(
                        modifier = Modifier.padding(innerPadding),
                        users = dummyUsers
                    )
                }
            }
        }
    }
}

@Composable
fun UserListComposable(
    users: List<User>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(horizontal = 12.dp)) {
        users.map { user ->
            item(user.id) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = user.name,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
