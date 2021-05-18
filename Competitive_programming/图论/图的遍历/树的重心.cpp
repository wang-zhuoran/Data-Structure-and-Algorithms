#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, M = N * 2;

int m, n;
int h[N], e[M], ne[M], idx;
bool st[N];

int ans = N; //全局的答案，存的就是最小的最大值

void add(int a, int b)
{
    e[idx] = b; 
    ne[idx] = h[a];
    h[a] = idx++;
}

//以u为根的子树的大小
int dfs(int u)
{
    st[u] = true;
    
    int sum = 1, res = 0;
    //sum表示当前子树的大小，当前的点算一个点/整个子树的节点数之和
    //res记录删掉这个点之后连通块的最大值
    for(int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if(!st[j]) 
        {
            int s = dfs(j); //当前节点的子树的大小（连通块）
            res = max(res, s);
            sum += s; 
        }
    }
    
    //子树上面的也要算
    res = max(n - sum, res);
    
    ans = min(ans, res);
    
    return sum;
}


int main()
{
    cin>>n;
    memset(h, -1, sizeof(h));
    
    for(int i = 0; i < n - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        add(a, b), add(b, a);
    }
    
    dfs(1);
    //从几号点开始搜都无所谓，因为是无向连通图
    cout << ans << endl;
    
    return 0;
}
