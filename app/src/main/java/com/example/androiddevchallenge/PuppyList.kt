package com.example.androiddevchallenge

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable

@Composable
fun PuppyList(puppyList: List<PuppyBean>?) {
    puppyList?.apply {
        LazyColumn(content = {
            itemsIndexed(this@apply) { index, puppy ->
                PuppyItem(puppy = puppy)
                if (index != puppyList.size - 1) {
                    Divider()
                }
            }
        })
    }
}