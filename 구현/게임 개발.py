n, m = map(int, input().split())
now_x, now_y, d = map(int, input().split())

dir = [0, 3, 2, 1]  # 북서남동
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

map_ = []
cnt = 1
for i in range(n):
    map_.append(list(map(int, input().split())))

idx = dir.index(d)+1
while(1):
    map_[now_x][now_y] = 1
    wx = now_x + dx[idx]
    wy = now_y + dy[idx]

    if map_[wx][wy] == 0:
        now_x = wx
        now_y = wy
        map_[wx][wy] = 1
        cnt += 1

    if idx < 3:
        idx += 1
    else:
        idx = 0
    
    count_n = 0
    for i in map_:
        if 0 not in i:
            count_n += 1
    if count_n == n:
        break

print(cnt)