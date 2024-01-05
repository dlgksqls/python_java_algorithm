def solution(N, stages):
    stage_count = [0] * (N+2)
    
    total_player = len(stages)  

    for stage in stages: 
        stage_count[stage] += 1

    fail_rates = []  
    for i in range(1, N+1): 
        if total_player == 0: 
            fail_rates.append((i, 0))
        else:
            fail_rate = stage_count[i] / total_player  
            fail_rates.append((i, fail_rate)) 
            total_player -= stage_count[i]  
    answer = [stage for stage, rate in sorted(fail_rates, key=lambda x: (-x[1], x[0]))]
    
    return answer