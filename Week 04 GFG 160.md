### day 22 Sort 0s, 1s and 2s

Given an array **arr[]** containing only **0s, 1s, and 2s.** Sort the array in ascending order.
You need to solve this problem without utilizing the built-in sort function.
**Examples:**
**Input:** arr[] = [0, 1, 2, 0, 1, 2]
**Output:** [0, 0, 1, 1, 2, 2]
**Explanation:** 0s 1s and 2s are segregated into ascending order.
**Input:** arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
**Output:** [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
**Explanation:** 0s 1s and 2s are segregated into ascending order.

```cpp
class Solution {
  public:
    void sort012(vector<int>& arr) {
        // code here
        sort(arr.begin(),arr.end());
        
    }
};
```
