package com.example.myfittrackapp.ui.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myfittrackapp.ui.theme.MyFitTrackAppTheme
import com.example.myfittrackapp.viewmodel.RegisterViewModel



@Composable
fun UserRegistrationScreen(
    viewModel: RegisterViewModel,
    onRegisterSuccess: () -> Unit,
    onLoginClick: () -> Unit
) {

    var step by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        FitnessHeader()

        Spacer(Modifier.height(20.dp))

        // Screen switch
        when(step) {
            0 -> PersonalInformationScreen(viewModel)
            1 -> BodyInformationScreen(viewModel)
        }

        Spacer(Modifier.height(20.dp))

        Row {

            if(step > 0){
                Button(onClick = { step-- }) {
                    Text("Back")
                }
            }

            Spacer(Modifier.weight(1f))

            Button(
                onClick = {
                    if(step == 0) step++
                    else onRegisterSuccess()
                }
            ) {
                Text(if(step == 0) "Next" else "Register")
            }
        }
    }
}

@Composable
fun FitnessHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF00C853),
                        Color(0xFF64DD17)
                    )
                )
            )
            .padding(20.dp)
    ) {
        Column {
            Text(
                "Welcome Athlete 💪",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                "Let's build your profile",
                color = Color.White.copy(alpha = 0.85f)
            )
        }
    }
}

@Composable
fun PersonalInformationScreen(vm: RegisterViewModel) {

    Column {

        OutlinedTextField(
            value = vm.firstName,
            onValueChange = { vm.firstName = it },
            label = { Text("First Name") }
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = vm.lastName,
            onValueChange = { vm.lastName = it },
            label = { Text("Last Name") }
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = vm.email,
            onValueChange = { vm.email = it },
            label = { Text("Email") }
        )

        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = vm.password,
            onValueChange = { vm.password = it },
            label = { Text("Password") }
        )
    }
}


@Composable
fun FormCard(content: @Composable () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            content()
        }
    }
}

@Composable
fun BodyInformationScreen(vm: RegisterViewModel) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {



        FormCard {

            Text(
                "Body Details",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(16.dp))

            Row {

                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = vm.height.toString(),
                    onValueChange = {
                        vm.height = it.toDoubleOrNull() ?: 0.0
                        vm.calculateBodyFat()
                    },
                    label = { Text("Height") }
                )

                Spacer(Modifier.width(10.dp))

                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = vm.weight.toString(),
                    onValueChange = {
                        vm.weight = it.toDoubleOrNull() ?: 0.0
                        vm.calculateBodyFat()
                    },
                    label = { Text("Weight") }
                )
            }

            Spacer(Modifier.height(20.dp))

            MetricDisplay(vm.bodyFat)
        }
    }
}


@Composable
fun MetricDisplay(bodyFat: Double) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE8F5E9)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                "Body Fat",
                fontWeight = FontWeight.SemiBold
            )

            Text(
                "${"%.1f".format(bodyFat)} %",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
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

