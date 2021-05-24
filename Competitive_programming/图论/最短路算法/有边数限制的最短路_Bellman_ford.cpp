#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 510, M = 10010;

int n, m, k;
int dist[N], backup[N];

struct Edge
{
    int a, b, w;
}edges[M];

int bellman_ford()
{
    memset(dist, 0x3f, sizeof dist);
    dist[1] = 0;
    
    for(int i = 0; i < k; i++) //不超过k条边，故迭代k次
    {
        memcpy(backup, dist, sizeof(dist));
        //每次备份一下dist
        for(int j = 0; j < m; j++)
        {
            int a = edges[j].a, b = edges[j].b, w = edges[j].w;
            dist[b] = min(dist[b], backup[a] + w);//只用上一次更新获得的结果来更新距离
        }
        
    }
    
    if(dist[n] > 0x3f3f3f / 2) return -1; //防止最后一步的负权边
    else return dist[n];
}

int main()
{
    scanf("%d%d%d", &n, &m, &k);
    
    for(int i = 0; i < m; i++)
    {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        edges[i] = {a, b, c};
    }
    
    int t = bellman_ford();
    
    if (t == -1) puts("impossible");
    else printf("%d\n", t);
    
    return 0;
}
