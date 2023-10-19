// time O(n) and space O(n)
class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val s1 = LinkedList<Char>()
        val s2 = LinkedList<Char>()

        for (c in s) {
            if (c == '#') {
                if (s1.isNotEmpty())
                    s1.removeLast()
            } else {
                s1.addLast(c)
            } 
        }

        for (c in t) {
            if (c == '#') {
                if (s2.isNotEmpty())
                    s2.removeLast()
            } else {
                s2.addLast(c)
            } 
        }

        return s1.joinToString("") == s2.joinToString("")
    }
}

// time O(n) and space O(1)
class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        var i = s.lastIndex
        var j = t.lastIndex
        var steps = 0

        while (true) {
            steps = 0
            while (i >= 0 && (steps > 0 || s[i] == '#')) {
                steps += if (s[i] == '#') 1 else -1
                i--
            }

            steps = 0
            while (j >= 0 && (steps > 0 || t[j] == '#')) {
                steps += if (t[j] == '#') 1 else -1
                j--
            }

            if (i >= 0 && j >= 0 && s[i] == t[j]) {
                i--
                j--
            } else {
                break
            }
        }

        return i == -1 && j == -1
    }
}
