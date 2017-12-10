package days

import days.day1.*
import days.day2.*
import days.day3.*

val list = listOf(
        ::day1p1, ::day1p2,
        ::day2p1, ::day2p2,
        ::day3p1, ::day3p2
)

val tests = listOf(
        listOf("1122", "1111", "1234", "91212129"), listOf("1212", "1221", "123425", "123123", "12131415"),
        listOf("5 1 9 5\n7 5 3\n2 4 6 8"), listOf("5 9 2 8\n9 4 7 3\n3 8 6 5"),
        listOf("1","12","23","1024"), listOf("54", "133", "330", "747")
)

val answers = listOf(
        listOf("3","4","0","9"),listOf("6","0","4","12","4"),
        listOf("18"), listOf("9"),
        listOf("0","3","2","31"), listOf("57", "142", "351", "806")
)