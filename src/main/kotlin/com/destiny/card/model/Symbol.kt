package com.destiny.card.model

enum class Symbol(val text: String) {
    BLANK("cannot be spent"),
    DISCARD("discard cards at random"),
    DISRUPT("discard resources"),
    FOCUS("turn a die to a new side"),
    MELEE("deal damage"),
    RANGED("deal damage"),
    RESOURCE("gain resources"),
    SHIELD("give shields"),
    SPECIAL("use card ability")
}