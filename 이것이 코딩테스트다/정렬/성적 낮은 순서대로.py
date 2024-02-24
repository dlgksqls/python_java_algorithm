n = int(input())

answers = []

for i in range(n):
    stu = input().split()
    answers.append((stu[0], int(stu[1])))

array = sorted(answers, key=lambda student: student[1])

for answer in array:
    print(answer[0], end=' ')