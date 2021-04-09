#include <iostream>

using namespace std;

int n;
const int N = 10;
int path[N], st[N];
//path的含义是从根节点到叶节点的一整条路径
//st的含义是每一个数有没有被用过

void dfs(int u){
    if(u == n){
        for(int i = 0; i<n; i++) printf("%d ", path[i]);
        puts("");
        return;
    }    
    
    for(int i = 1; i<=n; i++){
        
        if(!st[i]){
            path[u] = i;
            st[i] = true;
            dfs(u + 1);
            //恢复现场
            st[i] = false;
        }
    }
}

int main(void){
    cin>>n;
    
    dfs(0);
    
    return 0;
}
