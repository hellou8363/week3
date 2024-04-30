package org.example

class Storage {
    private val gameScore = mutableListOf<Int>()

    fun save(score: Int) {
        gameScore.add(score)
    }

    fun getGameScore(): MutableList<Int> {
        return gameScore
    }
}