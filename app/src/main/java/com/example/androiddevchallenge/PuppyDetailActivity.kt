package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.viewmodel.PuppyAdoptionDetailViewModel

class PuppyDetailActivity : AppCompatActivity() {
    private lateinit var mViewModel: PuppyAdoptionDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mViewModel = viewModel()
            initData()
            MyTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier.fillMaxWidth().height(55.dp)
                            .background(MaterialTheme.colors.primaryVariant)
                    ) {
                        Text(
                            text = mViewModel.puppyInfo.value?.name.toString(),
                            modifier = Modifier.align(
                                Alignment.Center
                            ),
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight(600)
                        )
                    }

                    Column(modifier = Modifier.padding(15.dp).fillMaxSize()) {

                        //puppy image
                        Image(
                            painter = painterResource(
                                id = mViewModel.puppyInfo.value?.puppyImage ?: R.mipmap.puppy1
                            ),
                            contentDescription = mViewModel.puppyInfo.value?.name,
                            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.FillWidth
                        )


                        //puppy name & gender
                        Box(
                            modifier = Modifier.padding(
                                start = 15.dp, end = 15.dp,
                                top = 15.dp, bottom = 5.dp
                            ).fillMaxWidth()
                        ) {

                            Divider()

                            Row(
                                modifier = Modifier.height(50.dp)
                            ) {
                                //name
                                Text(
                                    text = mViewModel.puppyInfo.value?.name ?: "",
                                    fontWeight = FontWeight(600),
                                    fontSize = 28.sp,
                                    color = Color.DarkGray,
                                    modifier = Modifier.align(Alignment.CenterVertically)
                                )

                                Box(
                                    modifier = Modifier.padding(start = 4.dp)
                                        .align(Alignment.CenterVertically)
                                ) {
                                    Image(
                                        painter = painterResource(id = if (mViewModel.puppyInfo.value?.gender == 0) R.mipmap.male else R.mipmap.female),
                                        contentDescription = if (mViewModel.puppyInfo.value?.gender == 0) "male" else "female",
                                        modifier = Modifier.width(16.dp).height(16.dp)
                                    )
                                }

                                if (mViewModel.puppyInfo.value?.vaccine == true) {
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
                        }


                        //puppy race
                        Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)) {
                            Image(
                                painter = painterResource(id = R.mipmap.dog),
                                contentDescription = "race",
                                modifier = Modifier.width(18.dp).height(18.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = mViewModel.puppyInfo.value?.race ?: "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color.Gray,
                                modifier = Modifier.align(Alignment.CenterVertically)
                                    .padding(start = 16.dp)
                            )
                        }

                        //puppy location
                        Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)) {
                            Image(
                                painter = painterResource(id = R.mipmap.location),
                                contentDescription = "location",
                                modifier = Modifier.width(16.dp).height(16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = mViewModel.puppyInfo.value?.location ?: "",
                                fontSize = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color.Gray,
                                modifier = Modifier.align(Alignment.CenterVertically)
                                    .padding(start = 16.dp)
                            )
                        }

                        //puppy age
                        Row(modifier = Modifier.padding(horizontal = 15.dp, vertical = 8.dp)) {
                            Image(
                                painter = painterResource(id = R.mipmap.age),
                                contentDescription = "location",
                                modifier = Modifier.width(16.dp).height(16.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Text(
                                text = "${mViewModel.puppyInfo.value?.age} Months",
                                fontSize = 20.sp,
                                fontWeight = FontWeight(500),
                                color = Color.Gray,
                                modifier = Modifier.align(Alignment.CenterVertically)
                                    .padding(start = 16.dp)
                            )
                        }

                        //description
                        Box(modifier = Modifier.padding(15.dp)) {
                            Text(text = mViewModel.puppyInfo.value?.description.toString(), fontSize = 18.sp, color = Color.Gray)
                        }
                    }
                }
            }
        }
    }

    private fun initData() {
        intent.getStringExtra("puppy_id")?.apply {
            mViewModel.getPuppyDataById(this)
        }
    }
}

