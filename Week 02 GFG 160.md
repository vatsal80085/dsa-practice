### day 8 Stock Buy and Sell - Multiple Transaction Allowed
Given an array ****prices[]**** of size ****n**** denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

****Note:**** We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

****Examples:****

> ****Input:**** prices[] = {100, 180, 260, 310, 40, 535, 695}  
> ****Output:**** 865  
> ****Explanation:**** Buy the stock on day 0 and sell it on day 3 => 310 - 100 = 210  
>                        Buy the stock on day 4 and sell it on day 6 => 695 - 40 = 655  
>                        Maximum Profit  = 210 + 655 = 865

```cpp
//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int maximumProfit(vector<int> &prices) {
        // code here
        int res = 0;
        for(int i=1; i<prices.size();i++){
            if(prices[i]>prices[i-1]){
                res+=prices[i]-prices[i-1];
            }
            
        }
        return res;
    }
};


//{ Driver Code Starts.
int main() {
    int t;

    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int n = arr.size();
        Solution ob;
        int res = ob.maximumProfit(arr);
        cout << res;
        cout << "\n";
        cout << "~"
             << "\n";
    }
    return 0;
}
// } Driver Code Ends
```