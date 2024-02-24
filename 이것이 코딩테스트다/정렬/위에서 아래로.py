answers = []

n = int(input())
for i in range(n):
    answers.append(int(input()))

array = sorted(answers, reverse=True)

for answer in array:
    print(answer, end=' ')