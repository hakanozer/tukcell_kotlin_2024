package com.tlh.dicevm.model

import com.tlh.dicevm.repository.DiceRollRepository

data class RollModel(
    var rollOne: Int? = null,
    val rollTwo: Int? = null,
    val rollNumber: Int = 0

)