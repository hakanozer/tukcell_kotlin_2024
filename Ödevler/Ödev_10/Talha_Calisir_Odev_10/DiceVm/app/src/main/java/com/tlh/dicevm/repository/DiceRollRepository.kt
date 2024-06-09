package com.tlh.dicevm.repository

import com.tlh.dicevm.model.RollModel


interface DiceRollRepository{
    fun rollDice(): RollModel
}