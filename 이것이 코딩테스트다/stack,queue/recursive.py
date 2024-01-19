def recursive_function(i):
    if i > 100:  # 종료 조건
        return print("재귀함수를 종료합니다.")
    else:
        print(f"{i}번째 재귀함수를 호출합니다.")
        i += 1
        recursive_function(i)


recursive_function(1)
