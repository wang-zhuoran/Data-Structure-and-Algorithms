#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

const int N = 110;

typedef pair<int, int> PII;

int n, m;
int g[N][N], d[N][N];
int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

int bfs()
{
    queue<PII> q;

    q.push({0, 0});

    memset(d, -1, sizeof(d));

    d[0][0] = 0;


    while (!q.empty())//队列不为空
    {
        auto t = q.front();//取队头元素

        q.pop();//出队

        for (int i = 0; i < 4; i++)
        {
            int x = t.first + dx[i], y = t.second + dy[i];

            if (x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1)
            {
                d[x][y] = d[t.first][t.second] + 1;//当前点到起点的距离
                q.push({x, y});//将新坐标入队
            }
        }
    }

    return d[n - 1][m -1];
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> g[i][j];

    cout << bfs() << endl;

    return 0;
}
