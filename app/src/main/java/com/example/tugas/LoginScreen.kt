package com.example.tugas

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun LoginScreen(){
    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var showDialog by remember {
        mutableStateOf(false)
    }

    val contex = LocalContext.current

     Column (modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     )
     {
         Text(text = "Tugas Intent")
         OutlinedTextField(value = username, onValueChange = {
             username = it
         }, label = { Text(text = "Username")})

         Spacer(modifier = Modifier.height(10.dp))

         OutlinedTextField(value = password, onValueChange = {
             password = it
         }, label = { Text(text = "Password")}
             ,visualTransformation = PasswordVisualTransformation())

         Spacer(modifier = Modifier.height(10.dp))

         Button(onClick = {showDialog = true})
         {
             Text(text = "Login")

             if (password == "adit" && username == "adit"){
                 val login = Intent(contex, tujuan::class.java)
                 contex.startActivity(login)
             }
             else if (showDialog) {
                 AlertDialog(onDismissRequest = {showDialog = true},
                     title = { Text(text = "Warning") },
                     text = { Text("Harap masukkan username atau password") },
                     confirmButton = {
                         TextButton(onClick = {showDialog = false}) {
                             Text("OK")
                         }
                     }
                 )
             } else if (showDialog){
                 AlertDialog(onDismissRequest = {showDialog = true},
                     title = { Text(text = "Warning") },
                     text = { Text("Password atau username anda salah") },
                     confirmButton = {
                         TextButton(onClick = {showDialog = false}) {
                             Text("OK")
                         }
                     },
                     properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
                 )
             }
         }
     }
    }