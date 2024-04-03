g=range;n,k=map(int,input().split())
r,m=[[0]*i+[1]+[0]*(n-i-1)for i in g(n)],[[*map(int,input().split())]for _ in g(n)]
for _ in g(k):r=[[sum(r[i][k]*m[k][j]for k in g(n))for j in g(n)]for i in g(n)]
for w in r:print(*w)