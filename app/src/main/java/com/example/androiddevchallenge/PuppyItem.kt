package com.example.androiddevchallenge

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
                modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                ).align(Alignment.CenterVertically).width(150.dp).height(85.dp),
                contentScale = ContentScale.FillWidth
            )

            Column(modifier = Modifier.padding(start = 15.dp).align(Alignment.CenterVertically)) {
                Row {
                    //puppy name
                    Text(
                        text = puppy.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(750),
                        color = Color.DarkGray,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    //gender
                    Box(
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 6.dp)
                    ) {
                        Image(
                            painter = painterResource(id = if (puppy.gender == 0) R.mipmap.male else R.mipmap.female),
                            contentDescription = if (puppy.gender == 0) "male" else "female",
                            modifier = Modifier.width(16.dp).height(16.dp)
                        )
                    }

                    if (puppy.vaccine) {
                        //vaccine
                        Box(
                            modifier = Modifier.align(Alignment.CenterVertically)
                                .padding(start = 6.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.mipmap.injector),
                                contentDescription = "vaccine",
                                modifier = Modifier.width(16.dp).height(16.dp)
                            )
                        }
                    }
                }


                //puppy race
                Row {
                    Image(
                        painter = painterResource(id = R.mipmap.dog),
                        contentDescription = "race",
                        modifier = Modifier.width(12.dp).height(12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = puppy.race,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(350),
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp)
                    )
                }

                //puppy location
                Row {
                    Image(
                        painter = painterResource(id = R.mipmap.location),
                        contentDescription = "location",
                        modifier = Modifier.width(12.dp).height(12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = puppy.location,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(350),
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp)
                    )
                }

                //puppy age
                Row {
                    Image(
                        painter = painterResource(id = R.mipmap.age),
                        contentDescription = "location",
                        modifier = Modifier.width(12.dp).height(12.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "${puppy.age} Months",
                        fontSize = 16.sp,
                        fontWeight = FontWeight(350),
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.CenterVertically).padding(start = 4.dp)
                    )
                }
            }

        }
    }
}
