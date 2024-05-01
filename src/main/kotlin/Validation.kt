package org.example

class Validation {

    fun validateInputValue(value: String): String {
        val number: Short

        try {
            number = value.toShort()

        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자 외 다른 값은 입력할 수 없습니다.")
        }

        if (value.first() == '0') {
            throw Exception("첫 번째 숫자는 0이 될 수 없습니다.")
        }

        if (value.length < 3 || value.length > 3) {
            throw Exception("세 자리 숫자를 입력해야 합니다.")
        }

        val numberSet = number.toString().toSet()

        if (numberSet.size < 3) {
            throw Exception("같은 숫자는 입력할 수 없습니다.")
        }

        return value
    }

    fun checkAnswer(value: List<Int>, userAnswer: List<Int>): String {
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