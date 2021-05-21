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
