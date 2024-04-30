package org.example

class Game {

    fun play(value: List<Int>, userAnswer: List<Int>): String {
        val strike = value.filterIndexed { index, c -> c == userAnswer[index] }.size
        val ball = value.filter { userAnswer.contains(it) }.size - strike
        var result = ""

        if (strike > 0) {
            result += "${strike}스트라이크 "

            if (strike == 3) {
                return "정답입니다!"
            }
        }

        if (ball > 0) {
            result += "${ball}볼 "
        }

        if (strike == 0 && ball == 0) {
            result = "Nothing"
        }

        return result
    }
}