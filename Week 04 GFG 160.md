### day 23 Find H-Index

Given an array ****citations[]**** of size ****n**** such that citations[i] is the number of citations a researcher received for ****ith**** paper, the task is to find the H-index. H-index(H) is the ****largest**** value such that the researcher has published ****at least H papers that have been cited**** ****at least H times****.

'H' stands for Hirsch index as it was proposed by the J.E. Hirsch in 2005. The H-index is defined as the author-level metric that attempts to measure both the productivity and the citation impact of the publication of the scientist or the scholar.

****Examples:****

> ****Input:**** citations[] = [5, 0, 2, 0, 2]  
> ****Output:**** 2  
> ****Explanation:**** There are at least 2 papers (5, 2, 2) with at least 2 citations.
> 
> ****Input:**** citations[] = [6, 0, 3, 5, 3]  
> ****Output:**** 3  
> ****Explanation:**** There are at least 3 papers (6, 5, 3, 3) with at least 3 citations.

```cpp
// C++ Program to find H-index using Counting Sort

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int hIndex(vector<int> &citations) {
    int n = citations.size();
    vector<int> freq(n + 1);
    // Count the frequency of citations
    for (int i = 0; i < n; i++) {
        if (citations[i] >= n)
            freq[n] += 1;
        else
            freq[citations[i]] += 1;
    }
    int idx = n;
    // Variable to keep track of the count of papers
    // having at least idx citations
    int s = freq[n]; 
    while (s < idx) {
        idx--;
        s += freq[idx];
    }
  
    // Return the largest index for which the count of 
    // papers with at least idx citations becomes >= idx
    return idx;
}
int main() {
    vector<int> citations = {6, 0, 3, 5, 3};
    cout << hIndex(citations) << "\n";
    return 0;
}
```
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
