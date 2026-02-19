package com.example.myfittrackapp.ui.health_record

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfittrackapp.ui.theme.FitnessBlue
import com.example.myfittrackapp.ui.theme.FitnessGreen
import com.example.myfittrackapp.ui.theme.MyFitTrackAppTheme
import com.example.myfittrackapp.viewmodel.HealthRecordViewModel

@Composable
fun HealthRecordScreen(){}

@Composable
fun HealthRecordDetails(vm: HealthRecordViewModel){}

@Composable
fun HealthRecordForm(vm: HealthRecordViewModel){
    Column(
        modifier = Modifier.padding(10.dp).height(500.dp),
    ) {
        OutlinedTextField(
            value = vm.height.toString(),
            onValueChange = { vm.height = it.toDouble() },
            label = { Text("Enter your height (cm)")},

        )
        OutlinedTextField(
            value = vm.weight.toString(),
            onValueChange = { vm.weight = it.toDouble() },
            label = {Text("Enter your current weight (KG)")}

        )
        Spacer(modifier = Modifier.height(10.dp))
        Column () {
            Text("Current BMI: ${vm.currentBMI}")
            Spacer(modifier = Modifier.height(10.dp))
            Text("Perfect BMI: ${vm.perfectBMI}")
        }
        Spacer(modifier = Modifier.height(10.dp))
        BodyFatStatus()

        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Button (onClick = { vm.calculateBMI() }, colors = ButtonDefaults.buttonColors(
                containerColor = FitnessGreen,
                contentColor = Color.White
            )) {
                Text("Save")
            }

        }
    }
}

@Composable
fun BodyFatStatus(){
    LinearProgressIndicator(
        progress = 0.8f,
        color = FitnessBlue,
        modifier = Modifier.padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HealthRecordFormPreview(){
    val vm = HealthRecordViewModel()
    MyFitTrackAppTheme() {
        HealthRecordForm(vm)
    }
}