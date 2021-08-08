#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

const int N = 210, INF = 1e9;

int n, m, Q;
int d[N][N];

void floyd()
{
    for(int k = 1; k <= n; k++)
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
}

int main()
{
    scanf("%d%d%d", &n, &m, &Q);
    
    for(int i = 1; i <= n; i++)
        for(int j = 1; j <= n; j++)
            if(i == j) d[i][j] = 0;
            else d[i][j] = INF;
            
    
    while(m --)
    {
        int a, b, w;
        scanf("%d%d%d", &a, &b, &w);
        d[a][b] = min(d[a][b], w);
    }
    
    floyd();
    
    while(Q --)
    {
        int a, b;
        scanf("%d%d", &a, &b);
        if(d[a][b] > INF / 2) printf("impossible\n");
        else printf("%d\n", d[a][b]);
    }
    
    return 0;
}
