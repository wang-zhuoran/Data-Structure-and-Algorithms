#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
#include <cstdio>

using namespace std;

const int N = 100010;
int n, m;
int h[N], e[N], ne[N], idx;
int d[N];

void add(int a, int b)
{
    e[idx] = b, ne[idx] = h[a], h[a] = idx ++;
}

int bfs()
{
    memset(d, -1, sizeof d);

    queue<int> q;
    d[1] = 0;
    q.push(1);

    while (q.size())
    {
        int t = q.front();
        q.pop();

        for (int i = h[t]; i != -1; i = ne[i])
        {
            int j = e[i];
            if (d[j] == -1)
            {
                d[j] = d[t] + 1;
                q.push(j);
            }
        }
    }

    return d[n];
}

void read()
{
    memset(h, -1, sizeof h);
    cin >> n >> m;
    int a, b;
    while(m -- ){
        scanf("%d%d", &a, &b);
        add(a, b);
    }
}

int main()
{
    read();
    
    cout << bfs() << endl;
    
    return 0;
}
