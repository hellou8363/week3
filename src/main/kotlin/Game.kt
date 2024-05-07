package org.example

class Game {
    private val storage by lazy { Storage() }
    private val validation by lazy { Validation() }
    private var count = 0

    fun start() {
        println("< 게임을 시작합니다. >")
        println("숫자를 입력하세요.")

        val correctAnswer = generateThreeRandomNumbers()

        while (true) {
            try {
                val input = readln()
                val userAnswer = validation.validateInputValue(input).map { Character.getNumericValue(it) }
                val playResult = validation.checkAnswer(userAnswer, correctAnswer)

                count++

                println(playResult)

                if (playResult.contains("정답")) {
                    storage.save(count)
                    count = 0
                    break
                }
            } catch (e: NumberFormatException) {
                println(e.message)
                println("숫자를 입력하세요.")
                continue
            } catch (e: Exception) {
                println(e.message)
                println("숫자를 입력하세요.")
                continue
            }
        }
    }

    fun viewRecords() {
        println("< 게임 기록 보기 >")
        storage.getGameScore().forEachIndexed { index, it ->
            println("${index + 1}번째 게임 : 시도 횟수 - $it")
        }
        println()
    }
}