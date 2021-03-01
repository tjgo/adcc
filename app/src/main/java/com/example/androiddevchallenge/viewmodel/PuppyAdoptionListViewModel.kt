package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.FakeAdoptionInfo
import com.example.androiddevchallenge.PuppyBean

class PuppyAdoptionListViewModel : ViewModel() {
    val puppies: MutableLiveData<List<PuppyBean>> = MutableLiveData()

    fun getAllPuppy() {
        //get fake data
        puppies.value = FakeAdoptionInfo.info
    }
}