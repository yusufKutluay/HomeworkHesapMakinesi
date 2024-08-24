package com.yusufkutluay.homeworkhesapmakinesi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.homeworkhesapmakinesi.ui.theme.HomeworkHesapMakinesiTheme

@Composable
fun Tasarim(sayi: String,color: Color, onClick : (String) -> Unit){

    val configuration = LocalConfiguration.current
    val screenWidthSize = configuration.screenWidthDp
    val screenHeightSize = configuration.screenHeightDp

    Row (modifier = Modifier.padding(all = 3.dp)){
        Card(
            onClick = {
                onClick(sayi)
            },
            modifier = Modifier
                .size((screenWidthSize/4.30).dp, (screenHeightSize / 5).dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = color
            )
        ){

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(
                    text = sayi,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,

                )
            }
        }
    }
}
