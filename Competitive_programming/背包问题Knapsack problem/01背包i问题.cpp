// 01 背包问题的朴素写法
//Knapsack 01
#include<bits/stdc++.h>
using namespace std;
const int N = 1010;
int f[N][N];
int v[N], w[N];
int n, m;
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> v[i] >> w[i];

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            f[i][j] = f[i - 1][j];
            if (j >= v[i]) f[i][j] = max(f[i][j], f[i - 1][j - v[i]] + w[i]);
        }
    }

    cout << f[n][m] << endl;
}
