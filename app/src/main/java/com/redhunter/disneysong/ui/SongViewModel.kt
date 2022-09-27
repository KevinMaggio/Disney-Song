package com.redhunter.disneysong.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redhunter.disneysong.model.SongData
import com.redhunter.disneysong.repository.SongRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SongViewModel:ViewModel() {

    private val repository= SongRepository()
    val dataSong= MutableLiveData<SongData>()
    val imageSong= MutableLiveData<Int>()

    fun getSong(){
        val result = repository.getRandomSong()
        dataSong.postValue(result)
    }

    fun getResult(){
        CoroutineScope(Dispatchers.IO).launch {
            Thread.sleep(16000)
            imageSong.postValue(dataSong.value?.image)
        }
    }
}