package org.example

class Game { // 정답을 체크하는 함수도 Game 클래스에 있어야 하는 이유를 잘 모르겠음
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
                val playResult = checkAnswer(userAnswer, correctAnswer)

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

    fun checkAnswer(value: List<Int>, userAnswer: List<Int>): String { // 유저가 입력한 숫자와 정답의 일치하는지 검증
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

    fun viewRecords() {
        println("< 게임 기록 보기 >")
        storage.getGameScore().forEachIndexed { index, it ->
            println("${index + 1}번째 게임 : 시도 횟수 - $it")
        }
        println()
    }
}