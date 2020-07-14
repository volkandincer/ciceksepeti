package com.example.ciceksepeti.Base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    internal var actionMutable = MutableLiveData<BaseViewModelAction>()

    val actionLiveData: LiveData<BaseViewModelAction> = actionMutable

    override fun onCleared() {
        super.onCleared()
        actionMutable.postValue(null)
    }
}