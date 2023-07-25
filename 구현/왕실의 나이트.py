input = input()

row = int(input[1])
column = ord(input[0])
count = 0
steps = [(2,-1),(2,1),(-2,-1),(-2,1),(1,2),(-1,2),(1,-2),(-1,-2)]

# dx = [2, 2, -2, -2, 1, -1]
# dy = [-1,1,-1,]
for step in steps:
    column_1 = column + step[0]
    row_1 = row + step[1]
    
    if row_1>=1 and row_1<=8 and column_1>=97 and column_1<=104:
        count = count+1

print(count)