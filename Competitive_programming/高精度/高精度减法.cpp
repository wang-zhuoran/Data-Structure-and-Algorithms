#include <iostream>
#include <vector>

using namespace std;

//判断A是否大于B
bool cmp(vector<int> &A, vector<int> &B){
    if(A.size() != B.size()) return A.size()>B.size();  //分两种情况
    //一个是A的长度和B的长度不相等，长的那个数大
    //另一种是不相等，一位位地比下去
    
    for(int i = A.size()-1; i>=0; i--){
        if(A[i]!=B[i]) return A[i]>B[i];
    }
    
    return true;
}

vector<int> sub(vector<int> &A, vector<int> &B){
    vector<int> C;
    int t = 0;
    for(int i = 0; i<=A.size()-1; i++){
        t = A[i] - t;
        if(i<B.size()) t-=B[i];
        
        C.push_back((t+10)%10);
        if(t<0) t = 1;
        else t = 0;
    }
    
    while(C.size()>1 && C.back()==0) C.pop_back();
    
    return C;
}

int main(void){
    string a, b;
    vector<int> A,B;
    cin>>a>>b;
    
    for(int i = a.size()-1; i>=0; i--) A.push_back(a[i]-'0');
    for(int i = b.size()-1; i>=0; i--) B.push_back(b[i]-'0');
    
    vector<int> C;
    
    if(cmp(A,B)) C = sub(A,B);
    else C = sub(B,A), printf("-");
    
    for(int i = C.size()-1; i>=0; i--) cout<<C[i];
    
    cout<<endl;
    
    return 0;
}
