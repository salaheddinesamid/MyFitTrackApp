package com.example.myfittrackapp.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myfittrackapp.R
import com.example.myfittrackapp.ui.theme.LoginButton
import com.example.myfittrackapp.ui.theme.MyFitTrackAppTheme

@Composable
fun LoginScreen(
    navController : NavController
){
    Scaffold()
         {
             LoginComposable(
                 onLoginSuccess = { navController.navigate("home") },
                 onRegisterClick = { navController.navigate("register") }
             )
         }
}
@Composable
fun LoginComposable(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 60.dp),
    ) {
        Text(
            text = stringResource(id = R.string.application_name),
            modifier = Modifier.padding(bottom = 10.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Welcome there, Please sign in to continue",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 15.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = ""
            },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = ""
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        LoginButton(
            "Login",
            onClick = {
                if (email.isBlank() || password.isBlank()) {
                    errorMessage = "Please enter email and password"
                } else {
                    onLoginSuccess()
                }
            },

        )

        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Or",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),

            onClick = { /*TODO*/ }

        ) { Text("Continue with Google")}

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = { /*TODO*/ }

        ) { Text("Continue with Facebook")}

        TextButton(
            onClick = onRegisterClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Create an account")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginComposablePreview() {
    MyFitTrackAppTheme() {
        LoginComposable(onLoginSuccess = {}, onRegisterClick = {})
    }
    //LoginComposable(onLoginSuccess = {}, onRegisterClick = {})
}
