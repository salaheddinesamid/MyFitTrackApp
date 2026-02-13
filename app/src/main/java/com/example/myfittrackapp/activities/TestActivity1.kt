package com.example.myfittrackapp.activities

import android.R.attr.onClick
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class TestActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            SwitchComposable()
        }

    }
}

@Composable
fun SwitchComposable (){
    val context = LocalContext.current
    Button(
        onClick = {
            val intent = Intent(context, TestActivity2::class.java)
            context.startActivity(intent)
        },
    ) {
        Text("Switch to Activity 2")
    }
}