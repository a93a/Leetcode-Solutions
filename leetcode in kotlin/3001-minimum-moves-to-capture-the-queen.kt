class Solution {
    fun minMovesToCaptureTheQueen(a: Int, b: Int, c: Int, d: Int, e: Int, f: Int): Int {
        // We can reach Q by either R or B in 1 move if their path cross and
        // and the other piece is not in the way
        // Check Q + R in same row and B not in between
        if (a == e && !(a == c && d.inLine(b, f))) return 1
        // Check Q + R in same column and B not in between
        if (b == f && !(b == d && c.inLine(a, e))) return 1
        // Check Q + R in same dia and B not in between
        if (c + d == e + f && !(a + b == e + f && a.inLine(c, e))) return 1
        // Check Q + R in same inv-dia and B not in between
        if (c - d == e - f && !(a - b == e - f && a.inLine(c, e))) return 1
        // Else we can reach Q from by R or B in 2 moves guaranteed
        return 2
    }

    // check if this int is inbetween int a and int b (we dont need to care about incl range)
    fun Int.inLine(a: Int, b: Int) = this in minOf(a, b)..maxOf(a, b)
}
