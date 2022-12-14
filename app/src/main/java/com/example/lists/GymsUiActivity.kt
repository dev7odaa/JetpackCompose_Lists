package com.example.lists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lists.ui.theme.ListsTheme
import com.example.lists.ui.theme.Purple200

class GymsUiActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ListContent()
                }
            }
        }
    }
}

@Composable
fun ListContent() {
    val vm: GymsViewModel = viewModel()
    LazyColumn(){
        items(vm.getGyms()){
            GymItem(it)
        }
    }
}

@Composable
fun GymItem(gymData: GymModel){
    var isFavouriteState = remember { mutableStateOf(false) }
    val icon = if (isFavouriteState.value){
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            DefaultIcon(Icons.Filled.Place, Modifier.weight(0.15f), "Gym Place")
            GymDetails(gymData, Modifier.weight(0.70f))
            DefaultIcon(icon, Modifier.weight(0.15f), "Favourite Icon"){
                isFavouriteState.value = !isFavouriteState.value
            }
        }
    }
}

@Composable
fun GymDetails(gym: GymModel, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = gym.gymName, style = MaterialTheme.typography.h6, color = Purple200)
        Text(text = gym.gymLocation, style = MaterialTheme.typography.body2, color = Color.Gray)
    }
}

@Composable
fun DefaultIcon(
    icon: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    onClick: () -> Unit = {},
) {
    Image(
        imageVector = icon,
        contentDescription = contentDescription,
        colorFilter = ColorFilter.tint(Color.DarkGray),
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() },
    )
}