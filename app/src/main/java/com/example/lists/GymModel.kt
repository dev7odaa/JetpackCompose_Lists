package com.example.lists

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.lists.ui.theme.Purple200


@Composable
fun GymDetails(gym: GymModel, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = gym.gymName, style = MaterialTheme.typography.h6, color = Purple200)
        Text(text = gym.gymLocation, style = MaterialTheme.typography.body2, color = Color.Gray)
    }

}

@Composable
fun GymIcon(imageVector: ImageVector, modifier: Modifier) {
    Image(
        imageVector = imageVector,
        contentDescription = "Gym Place",
        modifier = modifier,
        colorFilter = ColorFilter.tint(Color.DarkGray)
    )
}


data class GymModel(var gymName: String, var gymLocation: String)

val listOfGyms = listOf<GymModel>(
    GymModel("UpTown Gym", "Blalba blaa bla bla bla"),
    GymModel("Gold’s Gym", "Blalba blaa bla bla bla"),
    GymModel("Hammer Gym", "Blalba blaa bla bla bla"),
    GymModel("I-Energy Gym", "Blalba blaa bla bla bla"),
    GymModel("H2o Gym", "Blalba blaa bla bla bla"),
    GymModel("UpTown Gym", "Blalba blaa bla bla bla"),
    GymModel("Gold’s Gym", "Blalba blaa bla bla bla"),
    GymModel("Hammer Gym", "Blalba blaa bla bla bla"),
    GymModel("I-Energy Gym", "Blalba blaa bla bla bla"),
    GymModel("H2o Gym", "Blalba blaa bla bla bla"),
    GymModel("UpTown Gym", "Blalba blaa bla bla bla"),
    GymModel("Gold’s Gym", "Blalba blaa bla bla bla"),
    GymModel("Hammer Gym", "Blalba blaa bla bla bla"),
    GymModel("I-Energy Gym", "Blalba blaa bla bla bla"),
    GymModel("H2o Gym", "Blalba blaa bla bla bla"),
    GymModel("UpTown Gym", "Blalba blaa bla bla bla"),
    GymModel("Gold’s Gym", "Blalba blaa bla bla bla"),
    GymModel("Hammer Gym", "Blalba blaa bla bla bla"),
    GymModel("I-Energy Gym", "Blalba blaa bla bla bla"),
    GymModel("H2o Gym", "Blalba blaa bla bla bla"),
)