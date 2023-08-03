def solution(n):
    answer = 0
    list_result=[]
    n = str(n)
    for i in range(len(n)):
        list_result.append(n[i])
    list_result.sort(reverse=True)
    n = ''.join(list_result)
    n = int(n)
    return n