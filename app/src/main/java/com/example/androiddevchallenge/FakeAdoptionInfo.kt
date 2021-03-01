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

object FakeAdoptionInfo {
    val info = arrayListOf(
        PuppyBean("pet-1", R.mipmap.pekingese, "Xiaobai", 1,2, "Pekingese", "Haidian Beijing", "It's a lovely dog~", false),
        PuppyBean("pet-2", R.mipmap.corgi, "Wangcai", 0,4, "Corgi", "Jinghai Tianjin", "It's a lovely dog~", true),
        PuppyBean("pet-3", R.mipmap.husky, "Erhei", 1,9, "Husky", "Wuhan Hubei", "It's a lovely dog~",true),
        PuppyBean("pet-4", R.mipmap.bichon, "Tuanzi", 0,5, "Bichon", "Taipei Taiwan,China", "It's a lovely dog~", false),
        PuppyBean("pet-5", R.mipmap.chihuahua, "Qiuqiu", 0,6, "Chihuahua", "Hohhot Inner Mongolia", "It's a lovely dog~", true),
        PuppyBean("pet-6", R.mipmap.poodle, "Beibei", 1,3, "Poodle", "Xining Qinghai", "It's a lovely dog~", false),
        PuppyBean("pet-7", R.mipmap.labrador, "Jinfu", 0,7, "Labrador", "Sanya Hainan", "It's a lovely dog~", true),
        PuppyBean("pet-8", R.mipmap.akita, "Yuanzi", 0,8, "Akita", "Nanjing Jiangsu", "It's a lovely dog~", false)
    )
}