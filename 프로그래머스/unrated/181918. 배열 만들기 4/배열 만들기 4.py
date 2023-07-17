def solution(arr):
    stk = []
    i = 0
    
    while True:
        if stk == []:
            stk.append(arr[i])
            i = i+1
        elif stk[-1] < arr[i]:
            stk.append(arr[i])
            i = i+1
        elif stk[-1] >= arr[i]:
            del stk[-1]
        
        if i == len(arr):
            break
    return stk
