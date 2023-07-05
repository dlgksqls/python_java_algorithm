n = int(input())
dic = input().split()

x = 1
y = 1

dx = [0,0,-1,1]
dy = [-1,1,0,0]

location = ['L','R','U','D']

for i in dic:
    for j in range(len(location)):
        if i == location[j]:
            nx = x + dx[j]
            ny = y + dy[j]
    if nx<1 or ny<1 or nx>n or ny>n: #범위를 초과하면 반복문 맨 처음부터 시작함으로써 무시..
        continue 
    
    x, y = nx,ny
                
print(f"{x},{y}")
                