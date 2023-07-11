N = int(input())

n=list(map(int,input().split()))
n.sort(reverse=True)
a = []
count = 0

for i in range(len(n)):
    a.append(n[i])
    if len(a) == max(a):
        a.clear()
        count = count+1
        
print(count)
        