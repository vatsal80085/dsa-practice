### day 28 Merge Two Sorted Arrays Without Extra Space

Given two sorted arrays ****a[]**** and ****b[]**** of size ****n**** and ****m**** respectively, the task is to merge both the arrays and rearrange the elements such that the smallest ****n**** elements are in ****a[]**** and the remaining ****m**** elements are in ****b[]****. All elements in a[] and b[] should be in sorted order.

****Examples:**** 

> ****Input:**** a[] = [2, 4, 7, 10], b[] = [2, 3]  
> ****Output:**** a[] = [2, 2, 3, 4], b[] = [7, 10]   
> ****Explanation****: Combined sorted array = [2, 2, 3, 4, 7, 10], array a[] contains smallest 4 elements: 2, 2, 3 and 4, and array b[] contains remaining 2 elements: 7, 10.
> 
> ****Input:**** a[] = [1, 5, 9, 10, 15, 20], b[] = [2, 3, 8, 13]  
> ****Output:**** a[] = [1, 2, 3, 5, 8, 9], b[] = [10, 13, 15, 20]  
> ****Explanation****: Combined sorted array = [1, 2, 3, 5, 8, 9, 10, 13, 15, 20], array a[] contains smallest 6 elements: 1, 2, 3, 5, 8 and 9, and array b[] contains remaining 4 elements: 10, 13, 15, 20.
> 
> ****Input:**** a[] = [0, 1], b[] = [2, 3]  
> ****Output:**** a[] = [0, 1], b[] = [2, 3]   
> ****Explanation****: Combined sorted array = [0, 1, 2, 3], array a[] contains smallest 2 elements: 0 and 1, and array b[] contains remaining 2 elements: 2 and 3.

```cpp
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    void mergeArrays(vector<int>& a, vector<int>& b) {
        // code here
         int n = a.size();
        int m = b.size();
        int gap = (n + m + 1) / 2;
    
        while (gap > 0) {
            int i = 0, j = gap;
    
            while (j < n + m) {
    
                // If both pointers are in the first array a[]
                if (j < n && a[i] > a[j]) {
                    swap(a[i], a[j]);
                } 
              
                // If first pointer is in a[] and 
                // the second pointer is in b[]
                else if (i < n && j >= n && a[i] > b[j - n]) {
                    swap(a[i], b[j - n]);
                } 
              
                // Both pointers are in the second array b
                else if (i >= n && b[i - n] > b[j - n]) {
                    swap(b[i - n], b[j - n]);
                }
                i++;
                j++;
            }
    
            // After operating for gap of 1 break the loop
            if (gap == 1) break;
    
            // Calculate the next gap
            gap = (gap + 1) / 2;
        }
    }
};

//{ Driver Code Starts.

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t; // Inputting the test cases

    while (t--) {
        vector<int> a, b;

        // Reading the first array as a space-separated line
        string arr1;
        getline(cin >> ws, arr1); // Use ws to ignore any leading whitespace
        stringstream ss1(arr1);
        int num;
        while (ss1 >> num) {
            a.push_back(num);
        }

        // Reading the second array as a space-separated line
        string arr2;
        getline(cin, arr2);
        stringstream ss2(arr2);
        while (ss2 >> num) {
            b.push_back(num);
        }

        Solution ob;
        ob.mergeArrays(a, b);

        // Output the merged result
        for (int i = 0; i < a.size(); i++) {
            cout << a[i] << " ";
        }
        cout << endl;
        for (int i = 0; i < b.size(); i++) {
            cout << b[i] << " ";
        }
        cout << "\n";
        cout << "~\n";
    }

    return 0;
}

// } Driver Code Ends
```
### day  27 Non-Overlapping Intervals

Given a list of intervals with ****starting**** and ****ending**** values, the task is to find the minimum number of ****intervals**** that are required to be removed to make remaining intervals ****non-overlapping****.

****Examples:****

> ****Input:**** intervals[][] = [[1, 2], [2, 3], [3, 4], [1, 3]]  
> ****Output:**** 1  
> ****Explanation:**** Removal of [1, 3] makes the ranges non-overlapping.
> 
> ****Input:**** intervals[][] = [[1, 3], [1, 3], [1, 3]]  
> ****Output:**** 2  
> ****Explanation:**** Removal of two occurrences of [1, 3] makes the remaining ranges non-overlapping.
> 
> ****Input:**** intervals[][] = [[1, 2], [5, 10], [18, 35], [40, 45]]  
> ****Output:**** 0  
> ****Explanation:**** All ranges are already non-overlapping.

```cpp
// C++ program to minimum number of intervals required to
// be removed to make remaining intervals non-overlapping
// Using sorting by starting value

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int minRemoval(vector<vector<int>>& intervals) {
      int cnt = 0;
  
    // Sort by minimum starting point
    sort(intervals.begin(), intervals.end());

    int end = intervals[0][1];
    for (int i = 1; i < intervals.size(); i++) {

        // If the current starting point is less than
        // the previous interval's ending point
        // (ie. there is an overlap)
        if (intervals[i][0] < end) {
          
            // Increase cnt and remove the interval
            // with the higher ending point
              cnt++;
            end = min(intervals[i][1], end);
        }
          
          // Incase of no overlapping, this interval is 
          // not removed and 'end' will be updated
        else
            end = intervals[i][1];
    }

    return cnt;
}

int main() {
    vector<vector<int> > intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
    cout << minRemoval(intervals) << endl;
}
```

### day 26 Insert and Merge Interval

Given a set of ****non-overlapping**** intervals and a new ****interval****, the task is to insert the interval at the correct position such that after insertion, the intervals remain sorted. If the insertion results in ****overlapping**** intervals, then merge the overlapping intervals. Assume that the set of ****non-overlapping**** intervals is ****sorted**** based on ****start time****.

****Examples:**** 

> ****Input:**** intervals[][] = [[1, 3], [4, 5], [6, 7], [8, 10]], newInterval[] = [5, 6]  
> ****Output:**** [[1, 3], [4, 7], [8, 10]]  
> ****Explanation:**** The intervals [4, 5] and [6, 7] are overlapping with [5, 6]. So, they are merged into one interval [4, 7].
> 
> ****Input:**** intervals[][] = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval[] = [4, 9]  
> ****Output:**** [[1, 2], [3, 10], [12, 16]]  
> ****Explanation:**** The intervals [ [3, 5], [6, 7], [8, 10] ] are overlapping with [4, 9]. So, they are merged into one interval [3, 10].

```cpp
// C++ program to insert a new Interval in an array of sorted and 
// non-overlapping interval using Contiguous Interval Merging

#include <iostream>
#include <vector>
using namespace std;

// Function to insert and merge intervals
vector<vector<int>> insertInterval(vector<vector<int>>& intervals,
                                   vector<int> &newInterval) {
    vector<vector<int>> res;
    int i = 0;
    int n = intervals.size();

    // Add all intervals that come before the new interval
    while (i < n && intervals[i][1] < newInterval[0]) {
        res.push_back(intervals[i]);
        i++;
    }

    // Merge all overlapping intervals with the new interval
    while (i < n && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = min(newInterval[0], intervals[i][0]);
        newInterval[1] = max(newInterval[1], intervals[i][1]);
        i++;
    }
    res.push_back(newInterval);

    // Add all the remaining intervals
    while (i < n) {
        res.push_back(intervals[i]);
        i++;
    }

    return res;
}

int main() {
    vector<vector<int>> intervals = {{1, 3}, {4, 5}, {6, 7}, {8, 10}};
    vector<int> newInterval = {5, 6};
    
    vector<vector<int>> res = insertInterval(intervals, newInterval);
      for (vector<int> interval: res) {
          cout << interval[0] << " " << interval[1] << "\n";
    }
    return 0;
}
```
### day 25  Merge Overlapping Intervals

Given an array of time intervals, the task is to merge all the overlapping intervals into one and output the result which should have only mutually exclusive intervals.

****Examples:****

> ****Input:**** arr[] = [[1, 3], [2, 4], [6, 8], [9, 10]]  
> ****Output:**** [[1, 4], [6, 8], [9, 10]]  
> ****Explanation:**** In the given intervals, we have only two overlapping intervals [1, 3] and [2, 4]. Therefore, we will merge these two and return [[1, 4]], [6, 8], [9, 10]].
> 
> ****Input:**** arr[] = [[7, 8], [1, 5], [2, 4], [4, 6]]  
> ****Output:**** [[1, 6], [7, 8]]  
> ****Explanation:**** We will merge the overlapping intervals [[1, 5], [2, 4], [4, 6]] into a single interval [1, 6].

```cpp
// C++ Code to Merge Overlapping Intervals by checking 
// overlapping intervals only

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> mergeOverlap(vector<vector<int>>& arr) {

    // Sort intervals based on start values
    sort(arr.begin(), arr.end());
  
    vector<vector<int>> res;
    res.push_back(arr[0]);

    for (int i = 1; i < arr.size(); i++) {
        vector<int>& last = res.back();
        vector<int>& curr = arr[i];

        // If current interval overlaps with the last merged
        // interval, merge them 
        if (curr[0] <= last[1]) 
            last[1] = max(last[1], curr[1]);
        else 
            res.push_back(curr);
    }

    return res;
}

int main() {
    vector<vector<int>> arr = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
    vector<vector<int>> res = mergeOverlap(arr);

      for (vector<int>& interval: res) 
        cout << interval[0] << " " << interval[1] << endl;
 
    return 0;
}
```

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
