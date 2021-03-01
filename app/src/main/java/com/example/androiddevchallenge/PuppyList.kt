/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun PuppyList(puppyList: List<PuppyBean>?) {
    puppyList?.apply {
        LazyColumn(
            content = {
                itemsIndexed(this@apply) { index, puppy ->
                    PuppyItem(puppy = puppy)
                    if (index != puppyList.size - 1) {
                        Divider(color = Color.LightGray)
                    }
                }
            }
        )
    }
}
