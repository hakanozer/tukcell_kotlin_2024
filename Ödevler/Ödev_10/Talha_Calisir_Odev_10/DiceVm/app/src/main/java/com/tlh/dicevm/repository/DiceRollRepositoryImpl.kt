package com.tlh.dicevm.repository

import com.tlh.dicevm.model.RollModel

class DiceRollRepositoryImpl : DiceRollRepository {
    override fun rollDice(): RollModel {
        return RollModel(
            rollOne = (1..6).random(),
            rollTwo = (1..6).random(),
            rollNumber = 0
        )
    }
}