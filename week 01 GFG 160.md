###  day 1  Second Largest
Given an array of **positive** integers **arr[]**, return the **second largest** element from the array. If the second largest element doesn't exist then return **-1.**
Note: The second largest element should not be equal to the largest element.
**Examples:**
**Input:** arr[] = [12, 35, 1, 10, 34, 1]
**Output:** 34
**Explanation:** The largest element of the array is 35 and the second largest element is 34.
**Input:** arr[] = [10, 5, 10]
**Output:** 5
**Explanation:** The largest element of the array is 10 and the second largest element is 5.
**Input:** arr[] = [10, 10, 10]
**Output:** -1
**Explanation:** The largest element of the array is 10 and the second largest element does not exist.
**Constraints:**  
2 ≤ arr.size() ≤  10^5
1 ≤ arr[i] ≤ 10^5

```cpp
//{ Driver Code Starts
[[include]] <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    // Function returns the second
    // largest elements
    int getSecondLargest(vector<int> &arr) {
        // Code Here
        int n = arr.size();
        int largest = -1, second= -1;
        for(int i=0; i<n; i++){
            if(arr[i]>largest){
                second=largest;
                largest = arr[i];
            }
            else if(arr[i]<largest && arr[i]>second){
                second = arr[i];
            }
        }
        return second;
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
        Solution ob;
        int ans = ob.getSecondLargest(arr);
        cout << ans << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends
```
 ****[Expected Approach] One Pass Search - O(n) Time and O(1) Space****

> The idea is to keep track of the ****largest**** and ****second largest**** element while traversing the array. Initialize largest and second largest with ****-1****. Now, for any index i,
> 
> - If ****arr[i]**** ****> largest****, update second largest with largest and largest with arr[i].
> - Else If ****arr[i] < largest and arr[i] > second largest****, update second largest with arr[i].


### day 2 Given an array of integers ***arr[]****, the task is to move all the ***zeros**** to the ***end**** of the array while maintaining the relative order of all ****non-zero**** elements.

****Examples:**** 

> ****Input****: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]  
> ****Output****: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]  
> ****Explanation****: There are three 0s that are moved to the end.
> 
> ****Input****: arr[] = [10, 20, 30]  
> ****Output****: arr[] = [10, 20, 30]  
> ****Explanation****: No change in array as there are no 0s.  
>   
> ****Input****: arr[] = [0, 0]  
> ****Output****: arr[] = [0, 0]  
> ****Explanation****: No change in array as there are all 0s.

```cpp
//{ Driver Code Starts
[[include]] <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    void pushZerosToEnd(vector<int>& arr) {
        // code here
        int n = arr.size();
        vector<int> temp(n);
        int j=0;
        for(int i=0; i<n; i++){
            if(arr[i]!=0){
                temp[j++]=arr[i];
            }
        }
        while(j<n){
            temp[j++]=0;
        }
        for(int i=0; i<n; i++){
            arr[i]=temp[i];
        }
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
        Solution ob;
        int n = arr.size();
        ob.pushZerosToEnd(arr);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends
```

 ****[Expected Approach] One Traversal - O(n) Time and O(1) Space****

> The idea is similar to the previous approach where we took a pointer, say ****count**** to track where the ****next non-zero element**** should be placed. However, on encountering a ****non-zero**** element, instead of directly placing the ****non-zero**** element at ****arr[count]****, we will swap the non-zero element with arr[count]. This will ensure that if there is any zero present at ****arr[count],**** it is pushed towards the end of array and is not overwritten.

```cpp
// C++ Program to move all zeros to end using one traversal

[[include]] <bits/stdc++.h>
using namespace std;

// Function which pushes all zeros to end of array
void pushZerosToEnd(vector<int>& arr) {
  
    // Pointer to track the position for next non-zero element
    int count = 0;
     
    for (int i = 0; i < arr.size(); i++) {

        // If the current element is non-zero
        if (arr[i] != 0) {
          
            // Swap the current element with the 0 at index 'count'
            swap(arr[i], arr[count]);
            // Move 'count' pointer to the next position
            count++;
        }
    }
}

int main() {
    vector<int> arr = {1, 2, 0, 4, 3, 0, 5, 0};
    pushZerosToEnd(arr);
    for (int num : arr) {
        cout << num << " ";
    }
    return 0;
}
```

### day3 Reverse an Array
You are given an array of integers **arr[]**. Your task is to **reverse** the given array.

**Examples:  
**

**Input:** arr = [1, 4, 3, 2, 6, 5]
**Output:** [5, 6, 2, 3, 4, 1]  
**Explanation:** The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.

**Input**: arr = [4, 5, 2]
**Output:** [2, 5, 4]  
**Explanation:** The elements of the array are 4 5 2. The reversed array will be 2 5 4.

```cpp
//{ Driver Code Starts
[[include]] <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    void reverseArray(vector<int> &arr) {
        // code here
        int n = arr.size();
        vector<int> temp(n);
        for(int i=0;i<n; i++){
            temp[i] = arr[n-i-1]; 
        }
        for(int j=0;j<n;j++){
            arr[j]=temp[j];
        }
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

        Solution ob;
        ob.reverseArray(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}
// } Driver Code Ends
```

### day4 Rotate an Array
Given an array of integers arr[] of size n, the task is to rotate the array elements to the left by d positions.

Examples:

Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
Output: {3, 4, 5, 6, 1, 2}
Explanation: After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1} and after the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2}

Input: arr[] = {1, 2, 3}, d = 4
Output: {2, 3, 1}
Explanation: The array is rotated as follows:

After first left rotation, arr[] = {2, 3, 1}
After second left rotation, arr[] = {3, 1, 2}
After third left rotation, arr[] = {1, 2, 3}
After fourth left rotation, arr[] = {2, 3, 1}

this code solves the problem but gives TLE:
```cpp
class Solution {
  public:

    // Function to rotate an array by d elements in counter-clockwise direction.
    void rotateArr(vector<int>& arr, int d) {
        // code here
        int n = arr.size();
        for(int i=0; i<d; i++){
            int first = arr[0];
            for(int j=0; j<n-1; j++){
                arr[j]=arr[j+1];
            }
            arr[n-1]=first;
        }
    }
};
```

this is better approach:
```cpp
// C++ Program to left rotate the array by d positions
// using temporary array

[[include]] <bits/stdc++.h>
using namespace std;

// Function to rotate vector
void rotateArr(vector<int>& arr, int d) {
    int n = arr.size();

    // Handle case when d > n
    d %= n;
  
    // Storing rotated version of array
    vector<int> temp(n);

    // Copy last n - d elements to the front of temp
    for (int i = 0; i < n - d; i++)
        temp[i] = arr[d + i];

    // Copy the first d elements to the back of temp
    for (int i = 0; i < d; i++)
        temp[n - d + i] = arr[i];

    // Copying the elements of temp in arr
    // to get the final rotated vector
    for (int i = 0; i < n; i++)
        arr[i] = temp[i];
}

int main() {
    vector<int> arr = { 1, 2, 3, 4, 5, 6 };
    int d = 2;

    rotateArr(arr, d);

    // Print the rotated vector
    for (int i = 0; i < arr.size(); i++)
        cout << arr[i] << " ";

    return 0;
}
```

### day5  Next Permutation

Given an array ****arr[]**** of size ****n****, the task is to print the lexicographically next greater permutation of the given array. If there does not exist any greater permutation, then find the lexicographically smallest permutation of the given array.

Let us understand the problem better by writing all permutations of [1, 2, 4] in lexicographical order

[1, 2, 4], [1, 4, 2], [2, 1, 4], [2, 4, 1], [4, 1, 2] and [4, 2, 1]

If we give any of the above (except the last) as input, we need to find the next one in sequence. If we give last as input, we need to return the first one.

****Examples:****

> ****Input:**** arr = [2, 4, 1, 7, 5, 0]  
> ****Output:**** [2, 4, 5, 0, 1, 7]  
> ****Explanation:**** The next permutation of the given array is 2 4 5 0 1 7
> 
> ****Input:**** arr = {3, 2, 1]  
> ****Output:**** [1, 2, 3]  
> ****Explanation:**** As arr[] is the last permutation. So, the next permutation is the lowest one.

```cpp
// C++ Program to find the next permutation by 
// generating only next

#include <bits/stdc++.h>
using namespace std;

void nextPermutation(vector<int> &arr) {
  
    int n = arr.size(); 

     // Find the pivot index
    int pivot = -1; 
    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] < arr[i + 1]) {
            pivot = i;
            break;
        }
    }

    // If pivot point does not exist, reverse the
    // whole array
    if (pivot == -1) {
        reverse(arr.begin(), arr.end());
        return;
    }

    // find the element from the right that
    // is greater than pivot
    for (int i = n - 1; i > pivot; i--) {
        if (arr[i] > arr[pivot]) {
            swap(arr[i], arr[pivot]);
            break;
        }
    }

    // Reverse the elements from pivot + 1 to the 
    // end to get the next permutation
    reverse(arr.begin() + pivot + 1, arr.end());
}

int main()
{
    vector<int> arr = { 2, 4, 1, 7, 5, 0 };
    nextPermutation(arr);    
    for (int x : arr) 
        cout << x << " ";    
    return 0;
}
```


### day6 Majority Element
You are given an array of integer **arr[]** where each number represents a vote to a candidate. Return the candidates that have votes greater than **one-third** of the total votes, If there's **not** a majority vote, return an empty array. 

**Note:** The answer should be returned in an increasing format.

**Examples:**

**Input:** arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
**Output:** [5, 6]
**Explanation:** 5 and 6 occur more n/3 times.

**Input:** arr[] = [1, 2, 3, 4, 5]
**Output:** []  
**Explanation:** o candidate occur more than n/3 times.

**Constraint:**  
1 <= arr.size() <= 10^6  
-10^9  <= arr[i] <= 10^9

```cpp
// C++ program to find Majority elements in an array
// using nested loops

#include <iostream>
#include <vector>
using namespace std;

// Function to find Majority elements in an array
vector<int> findMajority(vector<int> &arr) {
    int n = arr.size();
    vector<int> res;

    for (int i = 0; i < n; i++) {     
        // Count the frequency of arr[i]
        int cnt = 0;
        for (int j = i; j < n; j++) {
            if (arr[j] == arr[i])
                cnt += 1;
        }     
        // Check if arr[i] is a majority element
        if (cnt > (n / 3)) {
          
            // Add arr[i] only if it is not already
            // present in the result
            if (res.size() == 0 || arr[i] != res[0]) {
                res.push_back(arr[i]);
            }
        }   
        // If we have found two majority elements, 
        // we can stop our search
        if (res.size() == 2) {
            if(res[0] > res[1])
                swap(res[0], res[1]);
            break;
        }
    }

    return res;
}
int main() {
    vector<int> arr = {2, 2, 3, 1, 3, 2, 1, 1};
    vector<int> res = findMajority(arr);
    for (int ele : res)
        cout << ele << " ";
    return 0;
}
```

### day7 Stock Buy and Sell - Multiple Transaction Allowed
Given an array ****prices[]**** of size ****n**** denoting the cost of stock on each day, the task is to find the maximum total profit if we can buy and sell the stocks any number of times.

****Note:**** We can only sell a stock which we have bought earlier and we cannot hold multiple stocks on any day.

****Examples:****

> ****Input:**** prices[] = {100, 180, 260, 310, 40, 535, 695}  
> ****Output:**** 865  
> ****Explanation:**** Buy the stock on day 0 and sell it on day 3 => 310 - 100 = 210  
>                        Buy the stock on day 4 and sell it on day 6 => 695 - 40 = 655  
>                        Maximum Profit  = 210 + 655 = 865


```cpp
#include <iostream>
#include <vector>
using namespace std;

int maxProfitRec(vector<int> &price, int start, int end) {
    int res = 0;
  
    // Consider every valid pair, find the profit with it
    // and recursively find profits on left and right of it
    for (int i = start; i < end; i++) {
        for (int j = i + 1; j <= end; j++) {
            if (price[j] > price[i]) {
                int curr = (price[j] - price[i]) + 
                            maxProfitRec(price, start, i - 1) + 
                              maxProfitRec(price, j + 1, end);
                res = max(res, curr);
            }
        }
    }
    return res;
}

// Wrapper function
int maximumProfit(vector<int> &prices) {
    return maxProfitRec(prices, 0, prices.size()-1);
}

int main() {
    vector<int> prices = {100, 180, 260, 310, 40, 535, 695};
    cout << maximumProfit(prices);
    return 0;
}
```
