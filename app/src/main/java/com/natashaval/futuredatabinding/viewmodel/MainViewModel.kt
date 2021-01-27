package com.natashaval.futuredatabinding.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natashaval.futuredatabinding.model.User

/**
 * Created by natasha.santoso on 21/01/21.
 */
class MainViewModel : ViewModel() {
    // TODO: A7. move user and score data to viewModel and make score Observable
    val user = User("Muhammad", "Mujir")
    private val _score = MutableLiveData(0)
    val score: LiveData<Int> = _score

    // TODO: A8. Refactor updateScore function and implement event handling Listener Binding
    fun updateScore(value: Int){
        _score.value = (_score.value ?: 0) + value;
        Log.d("score", score.value.toString());
        Log.d("score", _score.value.toString());
    }
}

@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int){
    view.visibility = if(number == 0) View.GONE else View.VISIBLE
}