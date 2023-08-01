def solution(myString):
    myString = list(myString)
    answer = ''
    for i in range(len(myString)):
        if myString[i] == 'a':
            myString[i] = myString[i].upper()
        elif myString[i] == 'A':
            pass
        elif myString[i].upper():
            myString[i] = myString[i].lower()
    return ''.join(myString)