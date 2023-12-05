package com.example.middel_test_viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LottoViewModel : ViewModel(){
    private var _numbers = MutableLiveData<IntArray>(IntArray(6) {0})
    val numbers: LiveData<IntArray>
        get() = _numbers

    fun generate() {
        var num = 0
        val newNumbers = IntArray(6) { 0 }

        for (i in newNumbers.indices) {
            do {
                num = Random.nextInt(1, 46)
            } while(newNumbers.contains(num)) // 만약 중복되는 숫자가 다시 나오게 되면 do로 돌아가서 랜덤으로 돌린다.
            newNumbers[i] = num
            Log.i("Number!!!", newNumbers[i].toString())
        }

        newNumbers.sort() // 정렬하고 반환

        _numbers.value = newNumbers
    }
}