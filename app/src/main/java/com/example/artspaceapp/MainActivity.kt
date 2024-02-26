package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()


                }
            }
        }
    }
}


@Composable
fun ArtSpace(modifier: Modifier = Modifier) {


    var artSpaceIndex by remember { mutableIntStateOf(0) }
    if (artSpaceIndex == -1 ) artSpaceIndex = 3
    if (artSpaceIndex == 4) artSpaceIndex = 0

    val paint: Int
    val artWorkTitle: Int
    val artist: Int
    val year: Int

    when (artSpaceIndex) {
        0 -> {
            paint = R.drawable.sunflowers
            artWorkTitle = R.string.sunflowers
            artist = R.string.vincent_van_gogh
            year = R.string.year_1888
        }
        1 -> {
            paint = R.drawable.the_old_guitarist
            artWorkTitle = R.string.the_old_guitarist
            artist = R.string.pablo_picasso
            year = R.string.year_1903
        }
        2 -> {
            paint = R.drawable.american_gothic
            artWorkTitle = R.string.american_gothic
            artist = R.string.grant_wood
            year = R.string.year_1930
        }
        else-> {
            paint = R.drawable.mona_lisa
            artWorkTitle = R.string.mona_lisa
            artist = R.string.leonardo_da_vinci
            year = R.string.year_1503
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .padding(30.dp)



    ) {

        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 30.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp,  bottom = 60.dp)
                .weight(4f)
        )

        {
            Image(
                painter = painterResource(id = paint),
                contentDescription = "Paint",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .padding(30.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
                .background(Color(0xFFE0E0E0))
                .weight(1f)




        ) {
            Text(
                fontWeight = FontWeight.Light,
                text = stringResource (id = artWorkTitle),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    fontWeight = FontWeight(700),
                    text = stringResource(id = artist),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                )
                Text(
                    text ="  ("+ stringResource(id =year)+ ")",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier

                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .weight(1f)



        ) {
            Button(onClick = { artSpaceIndex-- })
            {
                Text(
                    text = "Previous",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(90.dp)
                )

            }
            Button(onClick = { artSpaceIndex++})
            {
                Text(
                    text = "Next",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(90.dp)
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}
