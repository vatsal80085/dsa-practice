### day 13 Max Circular Subarray Sum

Given an array of integers **arr[]** in a **circular** fashion. Find the **maximum** subarray sum that we can get if we assume the array to be circular.
**Examples:**

**Input:** arr[] = [8, -8, 9, -9, 10, -11, 12]
**Output:** 22
**Explanation:** Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.

**Input:** arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
**Output:** 23
**Explanation:** Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].  

**Input:** arr[] = [-1, 40, -14, 7, 6, 5, -4, -1]   
**Output:** 52
**Explanation:** Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.

**Constraints:**  
1 <= arr.size() <= 10^5  
-10^4 <= arr[i] <= 10^4

```cpp
class Solution {
  public:
    // arr: input array
    // Function to find maximum circular subarray sum.
    int circularSubarraySum(vector<int> &arr) {

        // your code here
        int n = arr.size();
    int suffixSum = arr[n - 1];
    
    // maxSuffix array to store the value of 
    // maximum suffix occured so far.
    vector<int> maxSuffix(n + 1, 0);
    maxSuffix[n - 1] = arr[n - 1];
    
    for(int i = n - 2; i >= 0; i--) {
        suffixSum = suffixSum + arr[i];
        maxSuffix[i] = max(maxSuffix[i + 1], suffixSum);
    }
    
    // circularSum is Maximum sum of circular subarray
    int circularSum = arr[0];
    
    // normalSum is Maxium sum subarray considering 
    // the array is non-circular
    int normalSum = arr[0];
    
    int currSum = 0;
    int prefix = 0;
    
    for(int i = 0; i < n; i++) {
        
        // Kadane's algorithm
        currSum = max(currSum + arr[i], arr[i]);
        normalSum = max(normalSum, currSum);
      
        // Calculating maximum Circular Sum
        prefix = prefix + arr[i];
        circularSum = max(circularSum, prefix + maxSuffix[i+1]);
    }
    
    return max(circularSum, normalSum);
    }
};
```
### day 12 Maximum Product Subarray

Given an integer array, the task is to find the ****maximum product**** of any subarray.

****Examples:****

> ****Input:**** arr[] = {-2, 6, -3, -10, 0, 2}  
> ****Output:**** 180  
> ****Explanation:**** The subarray with maximum product is {6, -3, -10} with product = 6 * (-3) * (-10) = 180
> 
> ****Input:**** arr[] = {-1, -3, -10, 0, 60}  
> ****Output:**** 60  
> ****Explanation:**** The subarray with maximum product is {60}.

```cpp
// C++ program to find Maximum Product Subarray using 
// Traversal From Starting and End of an Array

#include <bits/stdc++.h>
using namespace std;

// function to find the product of max product subarray.
int maxProduct(vector<int> &arr) {
      int n = arr.size();
    int maxProd = INT_MIN;
  
    // leftToRight to store product from left to Right
    int leftToRight = 1;
  
    // rightToLeft to store product from right to left
    int rightToLeft = 1;
  
    for (int i = 0; i < n; i++) {
        if (leftToRight == 0)
            leftToRight = 1;
        if (rightToLeft == 0)
            rightToLeft = 1;
      
        // calculate product from index left to right
        leftToRight *= arr[i];
      
        // calculate product from index right to left
        int j = n - i - 1;
        rightToLeft *= arr[j];
        maxProd = max({leftToRight, rightToLeft, maxProd});
    }
    return maxProd;
}

int main() {
    vector<int> arr = { -2, 6, -3, -10, 0, 2 };
    cout << maxProduct(arr);
    return 0;
}
```
### day 11 Kadane's Algorithm

Given an integer array **arr[].** You need to find the **maximum** sum of a subarray.  

**Examples:**

**Input:** arr[] = [2, 3, -8, 7, -1, 2, 3]
**Output:** 11
**Explanation:** The subarray {7, -1, 2, 3} has the largest sum 11.

**Input:** arr[] = [-2, -4]
**Output:** -2
**Explanation:** The subarray {-2} has the largest sum -2.

**Input:** arr[] = [5, 4, 1, 7, 8]
**Output:** 25
**Explanation:** The subarray {5, 4, 1, 7, 8} has the largest sum 25.

**Constraints:  
** 1 ≤ arr.size() ≤ 10^5 - 10^9 ≤ arr[i] ≤ 10^4

```cpp
//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(vector<int> &arr) {
        // code here...
         int res = arr[0];
    int maxEnding = arr[0];

    for (int i = 1; i < arr.size(); i++) {
      
        // Find the maximum sum ending at index i by either extending 
        // the maximum sum subarray ending at index i - 1 or by
        // starting a new subarray from index i
        maxEnding = max(maxEnding + arr[i], arr[i]);
      
        // Update res if maximum subarray sum ending at index i > res
        res = max(res, maxEnding);
    }
    return res;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore(); // To discard any leftover newline characters
    while (t--)   // while testcases exist
    {
        vector<int> arr;
        string input;
        getline(cin, input); // Read the entire line for the array elements
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        cout << ob.maxSubarraySum(arr) << endl;
    }
}
// } Driver Code Ends
```


### day 10 Minimize the Heights II

Given an array **arr[]** denoting heights of **N** towers and a positive integer **K.**

For **each** tower, you must perform **exactly one** of the following operations **exactly once**.

- **Increase** the height of the tower by **K**
- **Decrease** the height of the tower by **K**

Find out the **minimum** possible difference between the height of the shortest and tallest towers after you have modified each tower.

You can find a slight modification of the problem [here](https://practice.geeksforgeeks.org/problems/minimize-the-heights-i/1/).  
**Note:** It is **compulsory** to increase or decrease the height by K for each tower. **After** the operation, the resultant array should **not** contain any **negative integers**.

**Examples :**

**Input:** k = 2, arr[] = {1, 5, 8, 10}
**Output:** 5
**Explanation:** The array can be modified as {1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.The difference between the largest and the smallest is 8-3 = 5.

**Input:** k = 3, arr[] = {3, 9, 12, 16, 20}
**Output:** 11
**Explanation:** The array can be modified as {3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.The difference between the largest and the smallest is 17-6 = 11. 

**Constraints**  
1 ≤ k ≤ 10^7
1 ≤ n ≤ 10^5 
1 ≤ arr[i] ≤ 10^7

```cpp
// C++ program to minimize the maximum difference
// between heights using Sorting

#include <bits/stdc++.h>
using namespace std;

// Function to minimize the maximum difference
int getMinDiff(vector<int> &arr, int k) {
    int n = arr.size();
    sort(arr.begin(), arr.end());
  
    // If we increase all heights by k or decrease all
    // heights by k, the result will be arr[n - 1] - arr[0]
    int res = arr[n - 1] - arr[0];

    //  For all indices i, increment arr[0...i-1] by k and
    // decrement arr[i...n-1] by k
    for (int i = 1; i < arr.size(); i++) {
      
        // Impossible to decrement height of ith tower by k, 
        // continue to the next tower
        if (arr[i] - k < 0)
            continue;
      
        // Minimum height after modification
        int minH = min(arr[0] + k, arr[i] - k);
      
        // Maximum height after modification
        int maxH = max(arr[i - 1] + k, arr[n - 1] - k);

        // Store the minimum difference as result
        res = min(res, maxH - minH);
    }
    return res;
}

int main() {

    int k = 6;
    vector<int> arr = {12, 6, 4, 15, 17, 10};

    int ans = getMinDiff(arr, k);
    cout << ans;

    return 0;
}
```
### day 9 Stock Buy and Sell – Max one Transaction Allowed

Given an array ****prices[]**** of length ****N****, representing the prices of the stocks on different days, the task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell.

_****Note:****_ __Stock must be bought before being sold.__

****Examples:****

> ****Input:**** prices[] = {7, 10, 1, 3, 6, 9, 2}  
> ****Output:**** 8  
> ****Explanation:**** Buy for price 1 and sell for price 9.
> 
> ****Input:**** prices[] = {7, 6, 4, 3, 1}   
> ****Output:**** 0  
> ****Explanation:**** Since the array is sorted in decreasing order, 0 profit can be made without making any transaction.  
>   
> ****Input:**** prices[] = {1, 3, 6, 9, 11}   
> ****Output:**** 10  
> ****Explanation:**** Since the array is sorted in increasing order, we can make maximum profit by buying at price[0] and selling at price[n-1]
```cpp
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    int maximumProfit(vector<int> &prices) {
        // code here
        int minSoFar = prices[0], res = 0;
  
    for (int i = 1; i < prices.size(); i++) {

        // Update the minimum value seen so
        // far if we see smaller
        minSoFar = min(minSoFar, prices[i]);
       
        // Update result if we get more profit                
        res = max(res, prices[i] - minSoFar);
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
        vector<int> prices;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            prices.push_back(number);
        }

        Solution ob;
        int ans = ob.maximumProfit(prices);
        cout << ans << endl;
    }
    return 0;
}

// } Driver Code Ends
```

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
