def solution(n, arr1, arr2):
    answer = []
    map_1 = []
    map_2 = []
    result=[]
    b=''
    for i in arr1:
        map_1.append(bin(i))
    for j in arr2:
        map_2.append(bin(j))
        
    for k in range(len(map_1)):
        answer.append(int(map_1[k],2) | int(map_2[k],2))
        
    for i in range(len(answer)):
        answer[i] = bin(answer[i])
    for i in answer:
        if len(i)-2<n:
            b+=' '*(n-(len(i)-2))
        for j in range(2,len(i)):
            if i[j] == '1':
                b+='#'
            elif i[j] == '0':
                b+=' '
        result.append(b)
        b=''
    return result