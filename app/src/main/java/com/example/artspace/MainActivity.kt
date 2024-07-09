package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val artNumber = remember { mutableStateOf(1) }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtCard(imageResId = R.drawable.ic_launcher_background)
        Spacer(modifier = Modifier.height(16.dp))
        ArtTitle(title = "Title", name = "Name")
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                onClick = { artNumber.value++.also { if (it > 5) artNumber.value = 1 } },
                modifier = Modifier.width(110.dp)
            ) {
                Text(text = stringResource(R.string.previous))
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(
                onClick = { artNumber.value--.also { if (it < 1) artNumber.value = 5 } },
                modifier = Modifier.width(110.dp)
            ) {
                Text(text = stringResource(R.string.next))
            }
        }
    }
}

@Composable
fun ArtCard(@DrawableRes imageResId: Int) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .height(445.dp)
                .width(250.dp)
        )
    }
}

@Composable
fun ArtTitle(title: String, name: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier
            .padding(16.dp)
            .height(100.dp)
            .width(250.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .fillMaxSize()
                .align(Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = name,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

val artList = listOf(
    Triple(R.drawable.kiruna, R.string.kiruna, R.string.isvec),
    Triple(R.drawable.machu_pichu, R.string.machu_picchu, R.string.peru),
    Triple(R.drawable.myanmar, R.string.bagan, R.string.myanmar),
    Triple(R.drawable.zakynthos_adas, R.string.zakintos_adasi, R.string.yunanistan),
    Triple(R.drawable.antkabir, R.string.an_tkabir, R.string.t_rkiye)
)

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}