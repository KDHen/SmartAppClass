package com.example.w01thefirst

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel(){
//    private var _numvers = intArrayOf(0, 0, 0, 0, 0, 0)
    private var _numbers = MutableLiveData<IntArray>(IntArray(6){ 0 })
    val numbers: LiveData<IntArray>
        get() = _numbers
    fun generate() {
        var num = 0
        val newNumbers = IntArray(6) { 0 }
//        newNumbers.forEach {Log.i("newNumbers!!!", "$it")}

        for (i in newNumbers.indices){
            do {
                num = Random.nextInt(1, 46)
            } while (newNumbers.contains(num))
            newNumbers[i] = num

            Log.i("Number!!!", newNumbers[i].toString())
        }
        _numbers.value = newNumbers
    }
}