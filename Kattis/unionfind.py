import sys

class DSU:
    def __init__(self, size):
        self.parents = [i for i in range(size)]
        self.rank = [1] * size

    def find(self, x):
        if self.parents[x] != x:
            self.parents[x] = self.find(self.parents[x])
        return self.parents[x]

    def union(self, x, y):
        px = self.find(x)
        py = self.find(y)
        if px == py:
            return
        if self.rank[px] > self.rank[py]:
            self.parents[py] = px
            self.rank[px] += self.rank[py]
        elif self.rank[py] > self.rank[px]:
            self.parents[px] = py
            self.rank[py] += self.rank[px]
        else:
            self.parents[px] = py
            self.rank[py] += 1

    def isConnected(self, a, b):
        return self.find(a) == self.find(b)

n, q = map(int, input().split())
dsu = DSU(n)

for line in sys.stdin:
  vals = line.split()
  c, a, b = vals[0], int(vals[1]), int(vals[2])

  if c == "?":
    print("yes" if dsu.isConnected(a, b) else "no")
  else:
    dsu.union(a, b)
