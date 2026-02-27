package ramirez.ruben.composepokedex.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ramirez.ruben.composepokedex.ui.theme.red


@Composable
fun Ability(type: String, label:String, value:String){
    if (type=="column"){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Label(label)
            Text(value)
        }
    }else{
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Label(label)
            Text(" " + value)
        }
    }
}

@Composable
fun Label(text:String){
    Text(text, color = red)
}