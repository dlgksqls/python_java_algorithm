x=1
y=1

n = int(input())

plan = input().split()

for i in plan:
    if i == 'L':
        if y == 1:
            pass
        else :
            y = y-1
    elif i == 'R':
        if y == n:
            pass
        else :
            y = y+1
    elif i == 'U':
        if x == 1:
            pass
        else : 
            x = x-1
    elif i == 'D':
        if x == n:
            pass
        else:
            x = x+1
print(x,y)