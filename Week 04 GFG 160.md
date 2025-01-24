### day 24  Count Inversions of an Array

Given an integer array ****arr[]**** of size ****n****, find the ****inversion**** ****count**** in the array. Two array elements ****arr[i]**** and ****arr[j]**** form an inversion if ****arr[i] > arr[j]**** and ****i < j.****

****Note:**** Inversion Count for an array indicates that how far (or close) the array is from being sorted. If the array is already sorted, then the inversion count is 0, but if the array is sorted in reverse order, the inversion count is maximum. 

****Examples:**** 

> ****Input:**** arr[] = {4, 3, 2, 1}  
> ****Output:**** 6

```cpp
// C++ program to Count Inversions in an array using merge sort

#include <iostream>
#include <vector>
using namespace std;

// This function merges two sorted subarrays arr[l..m] and arr[m+1..r] 
// and also counts inversions in the whole subarray arr[l..r]
int countAndMerge(vector<int>& arr, int l, int m, int r) {
  
    // Counts in two subarrays
    int n1 = m - l + 1, n2 = r - m;

    // Set up two vectors for left and right halves
    vector<int> left(n1), right(n2);
    for (int i = 0; i < n1; i++)
        left[i] = arr[i + l];
    for (int j = 0; j < n2; j++)
        right[j] = arr[m + 1 + j];

    // Initialize inversion count (or result) and merge two halves
    int res = 0;
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {

        // No increment in inversion count if left[] has a 
        // smaller or equal element
        if (left[i] <= right[j]) 
            arr[k++] = left[i++];
      
        // If right is smaller, then it is smaller than n1-i 
          // elements because left[] is sorted
        else {
            arr[k++] = right[j++];
            res += (n1 - i);
        }
    }

    // Merge remaining elements
    while (i < n1)
        arr[k++] = left[i++];
    while (j < n2)
        arr[k++] = right[j++];

    return res;
}

// Function to count inversions in the array
int countInv(vector<int>& arr, int l, int r){
    int res = 0;
    if (l < r) {
        int m = (r + l) / 2;

        // Recursively count inversions in the left and 
        // right halves
        res += countInv(arr, l, m);
        res += countInv(arr, m + 1, r);

        // Count inversions such that greater element is in 
          // the left half and smaller in the right half
        res += countAndMerge(arr, l, m, r);
    }
    return res;
}

int inversionCount(vector<int> &arr) {
      int n = arr.size();
      return countInv(arr, 0, n-1);
}

int main(){
    vector<int> arr = {4, 3, 2, 1};
    
    cout << inversionCount(arr);
    return 0;
}
```

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
