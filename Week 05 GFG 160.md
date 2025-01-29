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