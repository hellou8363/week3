package org.example

fun main() {
    val game = Game()

    println("[          숫자 야구 게임          ]")
    print("환영합니다! ")

    while (true) {
        println("원하시는 번호를 입력해주세요.")
        println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기")

        val input = readln()

        when (input) {
            "1" -> {
                game.start()
            }

            "2" -> {
                game.viewRecords()
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