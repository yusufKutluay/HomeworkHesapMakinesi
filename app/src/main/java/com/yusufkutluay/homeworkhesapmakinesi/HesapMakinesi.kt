package com.yusufkutluay.homeworkhesapmakinesi

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.homeworkhesapmakinesi.ui.theme.HomeworkHesapMakinesiTheme

@Composable
fun HesapMakinesi (){

    var tiklananDeger by remember { mutableStateOf("0") }
    var toplamDeger by remember { mutableStateOf(0) }
    var eskiDeger by remember { mutableStateOf("") }

    val configuration = LocalConfiguration.current
    val screenHeightSize = configuration.screenHeightDp

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom

        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screenHeightSize / 3.5).dp)
                    .padding(end = 15.dp, start = 15.dp)
                    .verticalScroll(rememberScrollState()),
                contentAlignment = Alignment.BottomEnd
            ) {

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "$eskiDeger",
                        fontSize = 40.sp,
                        textAlign = TextAlign.End,
                        lineHeight = 50.sp,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(12.dp))  // Metinler arasında boşluk bırakır


                    Text(
                        text = "$tiklananDeger",
                        fontSize = 60.sp,
                        textAlign = TextAlign.End,
                        lineHeight = 50.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                }

            }

            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.height((screenHeightSize/12).dp)) {
                Card(
                    onClick = {
                        tiklananDeger = "0"
                        eskiDeger = ""
                    },
                    modifier = Modifier
                        .weight(7f)
                        .padding(start = 10.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    )
                ){
                    Text(
                        text = "AC",
                        fontSize = 30.sp,
                        modifier = Modifier
                        .fillMaxWidth()
                            .padding(10.dp)
                        )
                }
                Image(
                    painter = painterResource(id = R.drawable.back_24),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .weight(1f)
                        .clickable {
                            tiklananDeger = tiklananDeger.dropLast(1)
                            if (tiklananDeger.isEmpty()) {
                                tiklananDeger = "0"
                            }
                        }
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in  7..9){
                    Tasarim(i.toString(), Color.LightGray){ if (tiklananDeger == "0") tiklananDeger = it else tiklananDeger += it }
                }
                Tasarim(sayi = "0",Color.LightGray){ if (tiklananDeger == "0") tiklananDeger = "0" else tiklananDeger += it}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in  4..6){
                    Tasarim(i.toString(), Color.LightGray){ if (tiklananDeger == "0") tiklananDeger = it else tiklananDeger += it }
                }
                Tasarim(sayi = "+",Color.Gray){ tiklananDeger += it}
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                for (i in  1..3){
                    Tasarim(i.toString(), Color.LightGray){ if (tiklananDeger == "0") tiklananDeger = it else tiklananDeger += it }
                }
                Tasarim(sayi = " = ",Color.Red){
                    hesaplaToplam(tiklananDeger)?.let { toplam ->
                        toplamDeger = toplam
                        eskiDeger = tiklananDeger
                         tiklananDeger = toplamDeger.toString()



                    }
                }

            }

        }
    }

}

fun hesaplaToplam(input: String): Int? {
    val sayilar = input.split("+")
    println(sayilar)
    return try {
        sayilar.sumOf { it.toIntOrNull() ?: 0 }
    } catch (e: NumberFormatException) {
        null
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeworkHesapMakinesiTheme {
        HesapMakinesi()
    }
}

