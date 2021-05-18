#include <iostream>

using namespace std;

int n;
const int N = 20;
char g[N][N];
bool col[N], dg[N], udg[N];

void dfs(int u){  //当前枚举第u行皇后可以放在哪一列
    if(u == n)
    {
         for(int i = 0; i<n; i++) puts(g[i]);
         puts("");
         return;
    }    
    
    for (int i = 0; i < n; i ++ )
        if (!col[i] && !dg[i + u] && !udg[i - u + n])
        {
            g[u][i] = 'Q';
            col[i] = dg[u + i] = udg[i - u + n] = true;
            dfs(u + 1);
            col[i] = dg[u + i] = udg[i - u + n] = false;
            g[u][i] = '.';
        }
}

int main(void){
    cin>>n;
    
    for(int i = 0; i<n; i++)
        for(int j = 0; j<n; j++)
            g[i][j] = '.';
    
    dfs(0);
    
    return 0;
}
