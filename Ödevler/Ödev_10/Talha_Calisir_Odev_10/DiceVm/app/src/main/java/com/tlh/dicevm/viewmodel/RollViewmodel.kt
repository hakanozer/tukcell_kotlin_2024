package com.tlh.dicevm.viewmodel

import androidx.lifecycle.ViewModel
import com.tlh.dicevm.model.RollModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RollViewmodel() : ViewModel() {
    private val _uiState = MutableStateFlow(RollModel())
    val uiState: StateFlow<RollModel> = _uiState.asStateFlow()

    fun rollDice() {
        _uiState.update { currentState ->
            if(RollModel().rollOne == null){
                currentState.rollOne = (1..6).random()
            }
            currentState.copy(
                rollOne = (1..6).random(),
                rollTwo = (1..6).random(),
                rollNumber = currentState.rollNumber + 1,
            )
        }
    }
}

