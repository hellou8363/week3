package org.example

fun main() {
    val storage = Storage()
    val validation = Validation()
    var count = 0 // 진행되는 게임이 시도 횟수

    println("[          숫자 야구 게임          ]")
    print("환영합니다! ")

    while (true) {
        println("원하시는 번호를 입력해주세요.")
        println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기")

        // 1. 유저에게 입력값을 받음
        val input = readln()

        when (input) {
            "1" -> {
                println("< 게임을 시작합니다. >")
                println("숫자를 입력하세요.")

                val correctAnswer = generateThreeRandomNumbers() // 랜덤한 3개의 숫자

                while (true) {
                    try {
                        val input = readln() // 정답과 매칭할 숫자 입력값

                        // 2. 정수로 변환되지 않는 경우 반복문 처음으로 돌아가기
                        // 3. 세자리가 아니거나, 0을 가지거나 특정 숫자가 두 번 사용된 경우 반복문 처음으로 돌아가기
                        val userAnswer = validation.validateInputValue(input).map { Character.getNumericValue(it) }

                        // 4. 정답과 유저의 입력값을 비교하여 스트라이크/볼을 출력하기
                        val playResult = validation.checkAnswer(userAnswer, correctAnswer)
                        count++

                        println(playResult)

                        // 5. 정답이라면 break를 호출하여 반복문 탈출하기
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

            "2" -> {
                println("< 게임 기록 보기 >")
                storage.getGameScore().forEachIndexed { index, it ->
                    println("${index + 1}번째 게임 : 시도 횟수 - $it")
                }
                println()
            }

            "3" -> {
                println("< 숫자 야구 게임을 종료합니다. >")
                break
            }

            else -> {
                println("올바른 숫자를 입력해주세요!")
            }
        }
    }
}