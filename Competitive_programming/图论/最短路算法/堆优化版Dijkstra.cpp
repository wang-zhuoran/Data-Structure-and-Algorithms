#include <iostream>
#include <cstring>
#include <algorithm>
#include <cstdio>
#include <queue>

using namespace std;

typedef pair<int, int> PII; //每一个点存进堆里的时候需要知道节点编号
//first存的是每个点到根节点的距离，second存的是节点编号

const int N = 1000100;

int n, m;
int h[N], w[N], e[N], ne[N], idx; //由于是稀疏图，改为邻接表的方式
int dist[N]; //1号点到每一个点的距离
bool st[N];

void add(int a, int b, int c)
{
    e[idx] = b, ne[idx] = h[a], w[idx] = c, h[a] = idx ++;
}

int dijkstra()
{
    memset(dist, 0x3f, sizeof(dist));

    dist[1] = 0;

    priority_queue<PII, vector<PII>, greater<PII>> heap; //小根堆
    heap.push({0, 1});
    
    while(heap.size())
    {
        auto t = heap.top();
        heap.pop();
        
        int ver = t.second, distance = t.first;
        
        if(st[ver]) continue; //冗余备份，直接忽略就可以了
        
        st[ver] = true;
        
        for (int i = h[ver]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (dist[j] > dist[ver] + w[i])
            {
                dist[j] = dist[ver] + w[i];
                heap.push({dist[j], j});
            }
        }
        
        
    }

    if (dist[n] == 0x3f3f3f3f) return -1;
    return dist[n];
}

int main(void){
    scanf("%d%d", &n, &m);
    
    memset(h, -1, sizeof(h));

    //下面读入m条边
    while(m--){
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        add(a, b, c);//重边无所谓了
    }

    int t = dijkstra();

    printf("%d\n", t);

    return 0;
}
