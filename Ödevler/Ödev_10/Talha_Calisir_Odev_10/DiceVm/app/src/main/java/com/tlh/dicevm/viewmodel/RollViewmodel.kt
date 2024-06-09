package com.tlh.dicevm.viewmodel

import androidx.lifecycle.ViewModel
import com.tlh.dicevm.model.RollModel
import com.tlh.dicevm.repository.DiceRollRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RollViewModel(private val repository: DiceRollRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(RollModel())
    val uiState: StateFlow<RollModel> = _uiState.asStateFlow()

    fun rollDices() {
        _uiState.update { currentState ->
            val newRoll = repository.rollDice()
            currentState.copy(
                rollOne = newRoll.rollOne,
                rollTwo = newRoll.rollTwo,
                rollNumber = currentState.rollNumber + 1,
            )
        }
    }
}

