#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>

typedef long long LL;

using namespace std;

const int N = 100010;

int n;
int x[N];

int main()
{
    scanf("%d", &n);
    for(int i = 0; i<n; i++) scanf("%d", &x[i]);
    
    sort(x, x + n);
    
    int c = x[n / 2];
    
    LL res = 0;
    
    for(int i = 0; i<n; i++) res += abs(c - x[i]);
    
    printf("%lld\n", res);
    
    return 0;
}
