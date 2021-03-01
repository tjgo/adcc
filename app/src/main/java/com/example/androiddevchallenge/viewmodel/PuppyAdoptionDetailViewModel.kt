package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.FakeAdoptionInfo
import com.example.androiddevchallenge.PuppyBean

class PuppyAdoptionDetailViewModel: ViewModel() {
    val puppyInfo: MutableLiveData<PuppyBean> = MutableLiveData()

    fun getPuppyDataById(id: String) {
        //get fake data
        puppyInfo.value = FakeAdoptionInfo.info.find { it.id == id }
    }
}