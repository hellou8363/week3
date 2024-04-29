package org.example

class Game {

    fun play() {
        val storage = Storage()
        val randomNumber = RandomNumber().generateThreeRandomNumbers()
        var count = 0

        println("< 게임을 시작합니다. >")
        println("숫자를 입력하세요")

        while (true) {
            val input = readln()
            count++

            try {
                val value = Validation.validateInputValue(input).map { Character.getNumericValue(it) }
                var result = ""
                val strike = value.filterIndexed { index, c -> c == randomNumber[index] }.size
                val ball = value.filter { randomNumber.contains(it) }.size - strike

                if (strike > 0) {
                    result += "${strike}스트라이크 "

                    if (strike == 3) {
                        println("정답입니다!\n")

                        storage.save(count)
                        break
                    }
                }

                if (ball > 0) {
                    result += "${ball}볼 "
                }

                if (strike == 0 && ball == 0) {
                    result = "Nothing"
                }

                println(result)

            } catch (e: NumberFormatException) {
                println(e.message)
            } catch (e: Exception) {
                println(e.message)
            }
        }

    }
}