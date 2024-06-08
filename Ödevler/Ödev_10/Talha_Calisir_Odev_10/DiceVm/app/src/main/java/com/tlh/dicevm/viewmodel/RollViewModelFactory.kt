package com.tlh.dicevm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tlh.dicevm.repository.DiceRollRepository

class RollViewModelFactory(private val repository: DiceRollRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RollViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RollViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
