#include <iostream>

using namespace std;

int main(void){
    double n;
    cin>>n;
    
    double l = -100, r = 100;
    
    while(r-l>1e-8){   //1e-8可以用来控制精度，如果要保留小数点后6位，一般选择1e-8
        double m = (l+r)/2;
        if(m*m*m>=n) r = m;
        else l = m;
    }
    
    printf("%lf", l);
    
    
    return 0;
}
