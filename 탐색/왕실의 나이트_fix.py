direction = input()

x = ord(direction[0])
y = int(direction[1])
count = 0

moves = [(2,1),(2,-1),(1,2),(-1,2),(-2,1),(-2,-1),(1,-2),(-1,-2)]

for i in moves:
    x_result = x + i[0]
    y_result = y + i[1]
    if x_result >= 97 and x_result <= 104 and y_result >= 1 and y_result <= 8:
        count = count + 1
        
print(count)