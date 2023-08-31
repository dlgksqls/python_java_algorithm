def solution(name, yearning, photo):
    answer = []
    
    
    for i in range(len(photo)):
        sum = 0
        for j in range(len(photo[i])):
            if photo[i][j] in name:
                # print(yearning[name.index(photo[i][j])])
                sum += yearning[name.index(photo[i][j])]
        answer.append(sum)
    return answer