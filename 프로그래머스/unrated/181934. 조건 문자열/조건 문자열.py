def solution(ineq, eq, n, m):
    answer = 0
    if ineq == '>' and eq == '=':
        answer = int(bool(n>=m))
    elif ineq == '>' and eq == '!':
        answer = int(bool(n>m))
    elif ineq == '<' and eq == '=':
        answer = int(bool(n<=m))
    else:
        answer = int(bool(n<m))
    
    return answer