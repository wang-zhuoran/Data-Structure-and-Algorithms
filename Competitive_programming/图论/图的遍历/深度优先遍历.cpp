#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100010, M = N*2;

int m, n;
int h[N], e[N], ne[N], idx;
bool st[N]; //储存布尔变量，代表这个节点是否被搜索过了

//添加一条边到图中, 由a指向b
void add(int a, int b){
	e[idx] = b, ne[idx] = h[a], h[a] = idx ++;
}

int dfs(int u)
{
    st[u] = true; // st[u] 表示点u已经被遍历过

    for (int i = h[u]; i != -1; i = ne[i])
    {
        int j = e[i];
        if (!st[j]) dfs(j);
    }
}

int main(void){
	idx = 0;
	memset(h, -1, sizeof h);
	
	return 0;
}
