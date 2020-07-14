package com.example.ciceksepeti.Base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


infix fun <T : Any> Boolean.then(param: T): T? = if (this) param else null

infix fun <T> Boolean.thenDo(action: () -> T): T? = if (this) action() else null


fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { action(it) } })
}
