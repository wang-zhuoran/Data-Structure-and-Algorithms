#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
#include <unordered_map>

using namespace std;

int bfs(string start)
{
    string end = "12345678x";
    
    queue<string> q; //宽搜队列
    unordered_map<string, int> d; //距离数组
    int dx[4] = {-1, 0, 1, 0}, dy[4] = {0, 1, 0, -1};

    q.push(start);
    d[start] = 0;
    
    while(q.size())
    {
        auto t = q.front();
        q.pop();
        
        int dist = d[t];
        
        if(t == end) return dist;
        
        //状态转移
        int k = t.find('x'); //返回x在字符串里的下标值
        int x = k / 3, y = k % 3;
        
        for(int i = 0; i < 4; i++)
        {
            int a = x + dx[i], b = y + dy[i];
            if(a >= 0 && a < 3 && b >= 0 && b < 3)
            {
                swap(t[k], t[a * 3 + b]);
                if(!d.count(t))
                {
                    d[t] = dist + 1;
                    q.push(t);
                }
                swap(t[k], t[a * 3 + b]);
            }
        }
        
    }
    
    return -1;
}

int main()
{
    string start;
    for(int i = 0; i < 9; i++)
    {
        char c;
        cin >> c;
        start += c;
    }
    
    cout << bfs(start) << endl;
    
    return 0;
}
