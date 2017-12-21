package days

import days.day1.*
import days.day10.*
import days.day11.*
import days.day12.*
import days.day13.*
import days.day14.*
import days.day15.day15p1
import days.day15.day15p2
import days.day2.*
import days.day3.*
import days.day4.*
import days.day5.*
import days.day6.*
import days.day7.*
import days.day8.*
import days.day9.*

val list = listOf(
        ::day1p1, ::day1p2,
        ::day2p1, ::day2p2,
        ::day3p1, ::day3p2,
        ::day4p1, ::day4p2,
        ::day5p1, ::day5p2,
        ::day6p1, ::day6p2,
        ::day7p1, ::day7p2,
        ::day8p1, ::day8p2,
        ::day9p1, ::day9p2,
        ::day10p1, ::day10p2,
        ::day11p1, ::day11p2,
        ::day12p1, ::day12p2,
        ::day13p1, ::day13p2,
        ::day14p1, ::day14p2,
        ::day15p1, ::day15p2
)

val tests = listOf(
        listOf("1122", "1111", "1234", "91212129"), listOf("1212", "1221", "123425", "123123", "12131415"),
        listOf("5 1 9 5\n7 5 3\n2 4 6 8"), listOf("5 9 2 8\n9 4 7 3\n3 8 6 5"),
        listOf("1","12","23","1024"), listOf("54", "133", "330", "747"),
        listOf("aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa"), listOf("abcde fghij\nabcde xyz ecdab\na ab abc abd abf abj\niiii oiii ooii oooi oooo\noiii ioii iioi iiio"),
        listOf("0\n3\n0\n1\n-3"), listOf("0\n3\n0\n1\n-3"),
        listOf("0 2 7 0"), listOf("0 2 7 0"),
        listOf("pbga (66)\nxhth (57)\nebii (61)\nhavc (66)\nktlj (57)\nfwft (72) -> ktlj, cntj, xhth\nqoyq (66)\npadx (45) -> pbga, havc, qoyq\ntknk (41) -> ugml, padx, fwft\njptl (61)\nugml (68) -> gyxo, ebii, jptl\ngyxo (61)\ncntj (57)"), listOf("pbga (66)\nxhth (57)\nebii (61)\nhavc (66)\nktlj (57)\nfwft (72) -> ktlj, cntj, xhth\nqoyq (66)\npadx (45) -> pbga, havc, qoyq\ntknk (41) -> ugml, padx, fwft\njptl (61)\nugml (68) -> gyxo, ebii, jptl\ngyxo (61)\ncntj (57)"),
        listOf("b inc 5 if a > 1\na inc 1 if b < 5\nc dec -10 if a >= 1\nc inc -20 if c == 10"), listOf("b inc 5 if a > 1\na inc 1 if b < 5\nc dec -10 if a >= 1\nc inc -20 if c == 10"),
        listOf("{}", "{{{}}}", "{{},{}}", "{{{},{},{{}}}}", "{<a>,<a>,<a>,<a>}", "{{<ab>},{<ab>},{<ab>},{<ab>}}", "{{<!!>},{<!!>},{<!!>},{<!!>}}", "{{<a!>},{<a!>},{<a!>},{<ab>}}"), listOf("<>", "<random characters>", "<<<<>", "<{!>}>", "<!!>", "<!!!>>", "<{o\"i!a,<{i<a>"),
        listOf("3, 4, 1, 5"), listOf("", "AoC 2017", "1,2,3", "1,2,4"),
        listOf("ne,ne,ne", "ne,ne,sw,sw", "ne,ne,s,s", "se,sw,se,sw,sw", "se,se,se,s,s", "s,s,se,ne", "s,s,s,se", "s,s,s,se,ne,se", "se,ne,se,s,s,s", "se,ne,se,n,n,n"), listOf("ne,ne,ne", "ne,ne,sw,sw", "ne,ne,s,s", "se,sw,se,sw,sw", "se,se,se,s,s", "s,s,se,ne", "s,s,s,se", "s,s,s,se,ne,se", "se,ne,se,s,s,s", "se,ne,se,n,n,n"),
        listOf("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5"), listOf("0 <-> 2\n1 <-> 1\n2 <-> 0, 3, 4\n3 <-> 2, 4\n4 <-> 2, 3, 6\n5 <-> 6\n6 <-> 4, 5"),
        listOf("0: 3\n1: 2\n4: 4\n6: 4"), listOf("0: 3\n1: 2\n4: 4\n6: 4"),
        listOf("flqrgnkx"), listOf("flqrgnkx"),
        listOf("Generator A starts with 65\nGenerator B starts with 8921"), listOf("Generator A starts with 65\nGenerator B starts with 8921")
)

val answers = listOf(
        listOf("3","4","0","9"),listOf("6","0","4","12","4"),
        listOf("18"), listOf("9"),
        listOf("0","3","2","31"), listOf("57", "142", "351", "806"),
        listOf("2"), listOf("3"),
        listOf("5"), listOf("10"),
        listOf("5"), listOf("4"),
        listOf("tknk"), listOf("60"),
        listOf("1"), listOf("10"),
        listOf("1", "6", "5", "16", "1", "9", "9", "3"), listOf("0", "17", "3", "2", "0", "0", "10"),
        listOf("12"), listOf("a2582a3a0e66e6e86e3812dcb672a272", "33efeb34ea91902bb2f59c9920caa6cd", "3efbe78a8d82f29979031a4aa0b16a9d", "63960835bcdc130f0b66d7ff4f6a5a8e"),
        listOf("3", "0", "2", "3", "5", "3", "4", "5", "5", "4"), listOf("3", "2", "2", "3", "5", "3", "4", "5", "5", "4"),
        listOf("6"), listOf("2"),
        listOf("24"), listOf("10"),
        listOf("8108"), listOf("1242"),
        listOf("588"), listOf("309")
)