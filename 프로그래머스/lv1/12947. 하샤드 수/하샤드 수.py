def solution(x):
    answer = True
    sum = 0
    y = str(x)
    for i in range(len(y)):
        sum += int(y[i])
        
    if x % sum == 0:
        return True
    else:
        return False
    