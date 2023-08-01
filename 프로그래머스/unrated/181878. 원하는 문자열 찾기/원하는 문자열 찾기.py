def solution(myString, pat):
    myString = myString.lower()
    pat = pat.lower()
    
    if len(myString) < len(pat):
        return 0
    if pat in myString:
        return 1
    elif pat not in myString:
        return 0