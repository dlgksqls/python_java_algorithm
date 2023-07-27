def solution(arr, query):
    answer = []
    for i in range(len(query)):
        if i % 2 == 0:
            del arr[query[i]+1:]
        else :
            del arr[:query[i]]
    answer.extend(arr)
    return answer