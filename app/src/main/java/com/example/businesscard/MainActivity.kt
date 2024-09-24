package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface {
                    BusinessCard(
                        stringResource(R.string.name_text),
                        stringResource(R.string.title_text),
                        stringResource(R.string.phone_text),
                        stringResource(R.string.email_text),
                        stringResource(R.string.github_user_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String,
                 title: String,
                 cellPhone : String,
                 email: String,
                 githubUser: String,
                 modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF1C623B))
    ){
        intro(name = name, title = title, modifier = modifier.fillMaxWidth())
        contactInfo(cellPhone, email, githubUser)
    }
}

@Composable
fun intro(name: String, title: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ){
        Image(
            painter = image,
            contentDescription = "Android Logo",
            modifier = modifier
                .padding(top = 100.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                .size(200.dp)
        )
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontSize = 33.sp,
            lineHeight = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            fontSize = 20.sp,
            lineHeight = 40.sp,
            color = Color.White
        )
    }
}
@Composable
fun contactInfo(phoneNumber: String, email: String, githubUser: String, modifier: Modifier =Modifier){
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ){
            Column (

            ){
                Icon(Icons.Rounded.Phone, contentDescription = "Phone", modifier = modifier.size(40.dp))
                Icon( Icons.Rounded.Email,contentDescription = "Email", modifier = modifier.size(40.dp))
                val image1 = painterResource(id = R.drawable.github)
                Image(painter = image1, contentDescription = null, modifier = modifier.size(40.dp))

            }
            Column (
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(start = 5.dp)

            ){

                Text(
                    text = phoneNumber,
//                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 22.sp,
                    lineHeight = 40.sp,
//                    fontWeight = FontWeight.Bold,
                    color = Color.White)
                Text(
                    text = email,
//                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 22.sp,
                    lineHeight = 40.sp,
//                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = githubUser ,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 22.sp,
                    lineHeight = 40.sp,
//                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
//    Row (
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = modifier.fillMaxWidth()
//        ){
//    }
//    Row (
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = modifier.fillMaxWidth()
//        ){
//        }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(
            stringResource(R.string.name_text),
            stringResource(R.string.title_text),
            stringResource(R.string.phone_text),
            stringResource(R.string.email_text),
            stringResource(R.string.github_user_text)
        )
    }
}