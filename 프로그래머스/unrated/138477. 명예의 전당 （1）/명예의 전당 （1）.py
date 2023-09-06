def solution(k, score):
    answer = []
    award = []
    
    for i in range(len(score)):
        if i < k:
            award.append(score[i])
            answer.append(min(award))
        elif score[i] > min(award):
            award.remove(min(award))
            award.append(score[i])
            answer.append(min(award))
        else:
            answer.append(min(award))
    return answer