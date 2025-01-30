
### day 30 Minimum in a Sorted and Rotated Array

Given a ****sorted**** array of distinct elements ****arr[]**** of size ****n**** that is rotated at some unknown point, the task is to find the ****minimum**** element in it. 

****Examples:**** 

> ****Input:**** arr[] ****=**** [5, 6, 1, 2, 3, 4]  
> ****Output:**** 1  
> ****Explanation:**** 1 is the minimum element present in the array.
> 
> ****Input:**** arr[] = [3, 1, 2]  
> ****Output:**** 1  
> ****Explanation****: 1 is the minimum element present in the array.
> 
> ****Input:**** arr[] = [4, 2, 3]  
> ****Output:**** 2  
> ****Explanation:**** 2 is the only minimum element in the array.

```cpp
// C++ program to find minimum element in a 
// sorted and rotated array using binary search

#include <iostream>
#include <vector>
using namespace std;

int findMin(vector<int> &arr) {
    int lo = 0, hi = arr.size() - 1;

    while (lo < hi) {
      
        // The current subarray is already sorted, 
        // the minimum is at the low index
        if (arr[lo] < arr[hi])        
            return arr[lo];
           
        // We reach here when we have at least
        // two elements and the current subarray
        // is rotated
      
        int mid = (lo + hi) / 2;

        // The right half is not sorted. So 
        // the minimum element must be in the
        // right half.
        if (arr[mid] > arr[hi])
            lo = mid + 1;
      
        // The right half is sorted. Note that in 
        // this case, we do not change high to mid - 1
        // but keep it to mid. As the mid element
        // itself can be the smallest
        else
            hi = mid;
    }

    return arr[lo]; 
}

int main() {
    vector<int> arr = {5, 6, 1, 2, 3, 4};
    cout << findMin(arr) << endl;
    return 0;
}
```

### day 29 Count number of occurrences (or frequency) in a sorted array

Given a ****sorted**** array ****arr[]**** and an integer ****target****, the task is to find the number of occurrences of ****target**** in given array.

****Examples:****

> ****Input:**** arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2  
> ****Output:**** 4  
> ****Explanation:**** 2 occurs 4 times in the given array.
> 
> ****Input:**** arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4  
> ****Output:**** 0  
> ****Explanation:**** 4 is not present in the given array.

```cpp
class Solution {
  public:
    int countFreq(vector<int>& arr, int target) {
        // code here
        int count=0;
        for(int i=0; i<arr.size(); i++){
            if(arr[i]==target){
                count++;
            }
        }
        return count;
```
