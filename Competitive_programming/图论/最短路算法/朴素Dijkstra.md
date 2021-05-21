### 朴素Dijkstra

稠密图用邻接矩阵存，稀疏图用邻接表存

Dijkstra算法用于求从1号点到其他所有点的最短距离。实现的思想是基于贪心的。

算法思路：

```cpp
1. dist[1] = 0 dist[i] = INF 初始化距离，由于是从1号点开始的，因此距离初始化为0; 
															其他的点为正无穷
2. 开一个集合s表示当前已确定最短距离的点
	for i : 1 ~ n:
		t <-- 不在s中的距离最近的点
		s <-- t
		用t更新其他点的距离

```

时间复杂度：$O(n^2)$

最短路算法不需要区分有向图和无向图，因为无向图可以看成特殊的有向图

代码模板

```cpp
int g[N][N]; //邻接矩阵
int dist[N]; //1号点到每一个点的距离
bool st[N];

int dijkstra()
{
    memset(dist, 0x3f, sizeof(dist));
		memset(g, 0x3f, sizeof(g));
    dist[1] = 0;
    
    for (int i = 0; i < n - 1; i ++ )
    {
        int t = -1;
        for (int j = 1; j <= n; j ++ )
            if (!st[j] && (t == -1 || dist[t] > dist[j]))
                t = j;

        for (int j = 1; j <= n; j ++ )
            dist[j] = min(dist[j], dist[t] + g[t][j]);

        st[t] = true;
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}
```
