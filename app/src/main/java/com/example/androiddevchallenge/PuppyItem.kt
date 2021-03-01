package com.example.androiddevchallenge

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PuppyItem(puppy: PuppyBean) {
    val context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth().height(120.dp)
            .clickable(onClick = {
                context.also {
                    it.startActivity(Intent(it, PuppyDetailActivity::class.java).apply {
                        putExtra("puppy_id", puppy.id)
                    })
                }
            })
    ) {
        //puppy item
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.CenterVertically)) {
            //puppy image
            Image(
                painter = painterResource(id = puppy.puppyImage),
                contentDescription = puppy.name,
                modifier = Modifier.wrapContentWidth().wrapContentHeight().clip(
                    RoundedCornerShape(10.dp)
                ).align(Alignment.CenterVertically)
            )

            Column(modifier = Modifier.padding(start = 15.dp).align(Alignment.CenterVertically)) {
                //puppy name
                Text(text = puppy.name, fontSize = 24.sp, fontWeight = FontWeight(750) , color = Color.DarkGray)

                //puppy race
                Row{
                    Image(painter = painterResource(id = R.mipmap.dog), contentDescription = "race", modifier = Modifier.width(12.dp).height(12.dp).align(Alignment.CenterVertically))
                    Text(text = puppy.race, fontSize = 16.sp, fontWeight = FontWeight(350), color = Color.Gray, modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp))
                }

                //puppy location
                Row {
                    Image(painter = painterResource(id = R.mipmap.location), contentDescription = "location", modifier = Modifier.width(12.dp).height(12.dp).align(Alignment.CenterVertically))
                    Text(text = puppy.location, fontSize = 16.sp, fontWeight = FontWeight(350), color = Color.Gray, modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp))
                }

                //puppy location
                Row {
                    Image(painter = painterResource(id = R.mipmap.age), contentDescription = "location", modifier = Modifier.width(12.dp).height(12.dp).align(Alignment.CenterVertically))
                    Text(text = "${puppy.age} Months", fontSize = 16.sp, fontWeight = FontWeight(350), color = Color.Gray, modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp))
                }
            }

        }
    }
}
