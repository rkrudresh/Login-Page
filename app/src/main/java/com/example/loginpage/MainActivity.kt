package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    shape = RoundedCornerShape(16.dp)
                )
                {

                    RadialGradientBackground()
                    LoginPage()
                }
            }
        }
    }
}


@Composable
fun RadialGradientBackground() {
    val gradient = Brush.radialGradient(
        0.0f to Color.LightGray,
        1.0f to Color.Cyan,
        radius = 1500.0f,
        tileMode = TileMode.Repeated
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(gradient)
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page", style = MaterialTheme.typography.displayMedium,
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(220.dp))

        val username = remember {
            mutableStateOf(TextFieldValue())
        }
        val password = remember {
            mutableStateOf(TextFieldValue())
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = username.value,
            onValueChange = {
                username.value = it
            },
            label = { Text(text = "Username", fontWeight = FontWeight.ExtraBold) },
            visualTransformation = VisualTransformation.None
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = { Text(text = "Password", fontWeight = FontWeight.ExtraBold) },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(
            onClick = { /*TODO*/ }) {
            Text(text = "Login")

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier
                .align(Alignment.End)
                .clickable { /* TODO: Handle Forgot Password click */ },
            text = "Forgot password?",
            style = MaterialTheme.typography.displayMedium,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(75.dp))
        Text(
            modifier = Modifier
                .clickable { /* TODO: Handle Forgot Password click */ },
            text = "Don't have an account | Register",
            style = MaterialTheme.typography.displayMedium,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginPageTheme {
            RadialGradientBackground()
            LoginPage()
        }
    }
