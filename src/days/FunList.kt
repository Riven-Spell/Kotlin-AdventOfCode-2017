package days

val list = listOf(
        ::Day1_1, ::Day1_2,
        ::Day2_1, ::Day2_2,
        ::Day3_1
)

val tests = listOf(
        listOf("1122", "1111", "1234", "91212129"), listOf("1212", "1221", "123425", "123123", "12131415"),
        listOf("5 1 9 5\n7 5 3\n2 4 6 8"), listOf("5 9 2 8\n9 4 7 3\n3 8 6 5"),
        listOf("1","12","23","1024")
)

val answers = listOf(
        listOf("3","4","0","9"),listOf("6","0","4","12","4"),
        listOf("18"), listOf("9"),
        listOf("0","3","2","31")
)