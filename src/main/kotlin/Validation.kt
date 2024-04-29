package org.example

class Validation { // 유효값 검증을 위한 클래스

    companion object {
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
                throw Exception("세 자리 숫자를 입력해주세요.")
            }

            val numberSet = number.toString().toSet()

            if (numberSet.size < 3) {
                throw Exception("같은 숫자는 입력할 수 없습니다.")
            }

            return value
        }
    }
}