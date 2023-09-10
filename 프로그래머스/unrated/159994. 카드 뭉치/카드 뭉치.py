def solution(cards1, cards2, goal):
    result = []
    idx_1 = 0
    idx_2 = 0
    
    for i in goal:
        if i == cards1[idx_1]:
            if idx_1 != len(cards1)-1:
                idx_1 += 1
        elif i == cards2[idx_2]:
            if idx_2 != len(cards2)-1:
                idx_2 += 1
        else:
             return "No"   
    return "Yes"