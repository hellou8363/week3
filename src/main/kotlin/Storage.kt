package org.example

class Storage {
    private val gameScoreList = mutableListOf<Int>()

    fun save(score: Int) {
        gameScoreList.add(score)
    }

    fun getGameScore(): MutableList<Int> {
        return gameScoreList
    }
}