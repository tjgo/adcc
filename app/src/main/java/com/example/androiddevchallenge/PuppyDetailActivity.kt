package com.example.androiddevchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                            color = Color.White
                        )
                    }

                    Column() {

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

