package org.example

class RandomNumber {

    fun generateThreeRandomNumbers(): List<Int> {
        val numberSet = mutableSetOf<Int>()

        while(numberSet.size < 3) {
            val random1to9 = (1..9).random()

            numberSet.add(random1to9)
        }

        return numberSet.toList()
    }
}