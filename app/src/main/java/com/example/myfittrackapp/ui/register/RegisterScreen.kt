package com.example.myfittrackapp.ui.register

import com.example.myfittrackapp.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myfittrackapp.ui.theme.FitnessBlue
import com.example.myfittrackapp.ui.theme.FitnessGreen
import com.example.myfittrackapp.ui.theme.MyFitTrackAppTheme
import com.example.myfittrackapp.viewmodel.RegisterViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(
    viewModel: RegisterViewModel,
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit
) {

    Scaffold(
        topBar = { TopAppBar(title = { Text("MyFitTrack") }) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(top = 40.dp)
        ){
            Spacer(modifier = Modifier.height(10.dp))
            RegistrationForm(vm = viewModel)
        }
    }
}


@Composable
fun RegistrationLabel(){
    Column() {
        Text(
            text = stringResource(R.string.registration_label),
            modifier = Modifier.padding(2.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Text(
            text = stringResource(R.string.registration_sub_label),
            modifier = Modifier.padding(2.dp),
            fontSize = 15.sp
        )
    }
}


@Composable
fun RegistrationForm(vm: RegisterViewModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        RegistrationLabel()

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = vm.firstName,
            onValueChange = { vm.firstName = it },
            label = { Text("First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = vm.lastName,
            onValueChange = { vm.lastName = it },
            label = { Text("Last Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = vm.email,
            onValueChange = { vm.email = it },
            modifier = Modifier.fillMaxWidth(),
            label = {Text("email@example.com")}
        )
        OutlinedTextField(
            value = vm.password,
            onValueChange = { vm.password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") },

        )
        OutlinedTextField(
            value = vm.password,
            onValueChange = { vm.password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Confirm Password") },
            )
        Button(
            onClick = { /* Handle register button click */ },
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = FitnessBlue,
                contentColor = Color.White
            )
        ){
            Text("Create your account")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 10.dp), text = "Or")

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = FitnessGreen,
                contentColor = Color.White
            ),

            onClick = { /*TODO*/ }

        ) { Text("Continue with Google")}

        Spacer(modifier = Modifier.height(12.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            onClick = { /*TODO*/ }

        ) { Text("Continue with Facebook")}
        Spacer(modifier = Modifier.weight(1f))

    }
}


@Composable
fun RegistrationFormPreview(){
    val vm = RegisterViewModel()
    MyFitTrackAppTheme() {
        RegistrationForm(vm)
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterPreview() {
    val vm = RegisterViewModel()

    MyFitTrackAppTheme {
        UserRegistrationScreen(
            viewModel = vm,
            onRegisterSuccess = {},
            onLoginClick = {}
        )
    }
}

