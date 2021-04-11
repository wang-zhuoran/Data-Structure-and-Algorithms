#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>

using namespace std;

const int N = 100100;

int n;
int price[N];

int main()
{
    scanf("%d", &n); // 读入个数
    for(int i = 0; i<n; i++) scanf("%d", &price[i]); // 读入价格
    
    int res = 0;
    
    for(int i = 0; i + 1 < n; i++){
        int dt = price[i + 1] - price[i];
        
        if(dt > 0)
        {
            res += dt;
        }
    }
    
    printf("%d\n", res);
    
    return 0;
}
