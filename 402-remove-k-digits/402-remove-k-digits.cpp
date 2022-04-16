class Solution {
public:
    string removeKdigits(string num, int k) 
    {
         if(k == num.length()) return "0";
        
         stack<char> stk;
         
          int i = 0;
        
          while(i < num.length())
         {
              while(k>0 && !stk.empty() && stk.top()>num[i]) {
                  stk.pop();
                  k--;
              }
              stk.push(num[i]);
              i++;
         }
        //to handle 111 and k=2 to get 1 as res
        while(k>0) 
        {
            stk.pop();
            k--;
        }
            
          string res;
          while(!stk.empty())
          {
              res += stk.top();
              stk.pop();
          }
          
          reverse(res.begin(), res.end());
          //to handle leading zeros 00012 should become 12 or 0000 should become 0
        while(res.length()>1 && res[0]=='0') {
            res.erase(res.begin());
        }
        
           if(res == "") return "0";
           return res;
    }
};