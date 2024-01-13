# def solution(N, stages):
#     answer = []
#     percentage = []
#     fail_num = []
#     stages.sort()
#     start = 0
#     count_num = 0

#     for i in range(0, len(stages)):
#         if stages[i] > N:
#             continue
#         elif stages[start] == stages[i]:
#             count_num = stages.count(stages[i])
#             continue
#         else:
#             start = i
#             fail_num.append(count_num)
#             count_num = stages.count(stages[i])
#     fail_num.append(count_num)

#     length = len(stages)

#     for i in fail_num:
#         percentage.append(i / length)
#         length -= i

#     percentage_with_index = list(enumerate(percentage, start=1))

#     sorted_stages = sorted(percentage_with_index, key=lambda x: (-x[1], x[0]))

#     answer = [stage_num for stage_num, _ in sorted_stages]

#     return fail_num


def solution(N, stages):
    answer = []
    percentage = []
    fail_num = [0] * (N + 1)
    stages.sort()
    start = 0
    count_num = 0

    for i in range(0, len(stages)):
        if stages[i] > N:
            continue
        elif stages[start] == stages[i]:
            count_num = stages.count(stages[i])
            continue
        else:
            start = i
            fail_num[stages[i - 1]] = count_num
            count_num = stages.count(stages[i])
    fail_num[stages[i - 1]] = count_num
    length = len(stages)

    for i in fail_num[1:]:
        if length != 0:
            percentage.append(i / length)
            length -= i
        else:
            percentage.append(0)

    answer = [
        stage_num
        for stage_num, fail_rate in sorted(
            enumerate(percentage, start=1), key=lambda x: (-x[1], x[0])
        )
    ]

    return answer


answer = solution(4, [4, 4, 4, 4, 4])
print(answer)
