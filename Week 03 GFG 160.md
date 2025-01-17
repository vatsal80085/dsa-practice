### day 17 Anagrams Strings
Given two strings ****s1**** and ****s2**** consisting of ****lowercase**** characters, the task is to check whether the two given strings are ****anagrams**** of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different.

****Examples:****

> ****Input:**** s1 = “geeks”  s2 = “kseeg”  
> ****Output:**** true  
> ****Explanation:**** Both the string have same characters with same frequency. So, they are anagrams.
> 
> ****Input:**** s1 = “allergy”  s2 = “allergic”  
> ****Output:**** false  
> ****Explanation:**** Characters in both the strings are not same. s1 has extra character ****'y'**** and s2 has extra characters 'i' and 'c', so they are not anagrams.
> 
> ****Input:**** s1 = "g", s2 = "g"  
> ****Output:**** true  
> ****Explanation:**** Characters in both the strings are same, so they are anagrams.

```cpp
// C++ Code to check if two Strings are anagram of 
// each other using Frequency Array

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// As the input strings can only have lowercase 
// characters, the maximum characters will be 26
const int MAX_CHAR = 26;

bool areAnagrams(string &s1, string &s2) {
    vector<int> freq(MAX_CHAR, 0);
    
    // Count frequency of each character in string s1
    for(char ch: s1) 
        freq[ch - 'a']++;
  
    // Count frequency of each character in string s2
    for(char ch: s2) 
        freq[ch - 'a']--;
  
    // Check if all frequencies are zero
    for (int count : freq) {
        if (count != 0) 
            return false;
    }
    
    return true;
}

int main() {
    string s1 = "geeks";
    string s2 = "kseeg";
    cout << (areAnagrams(s1, s2) ? "true" : "false") << endl;

    return 0;
}
```
### day 16 Add two binary strings

Given two binary strings ****s1**** and ****s2****, the task is to return their ****sum****.The ****input**** strings ****may contain leading zeros**** but the ****output**** string ****should not**** have any ****leading zeros****.

****Example:**** 

> ****Input:**** s1 = "1101", s2 = "111"  
> ****Output:**** "10100"  
> ****Explanation****:
> 
> ![Add-two-binary-strings-using-Bit-by-Bit-addition](https://media.geeksforgeeks.org/wp-content/uploads/20241011123008598976/Add-two-binary-strings-using-Bit-by-Bit-addition.webp)
> 
> ****Input:**** s1 = "00100", s2 = "010"  
> ****Output:**** "110"

```cpp
// C++ program to add two binary strings
// using Bit-by-Bit addition
#include <iostream>
using namespace std;

// Function to trim leading zeros from a binary string
string trimLeadingZeros(const string &s) {
    
    // Find the position of the first '1'
    size_t firstOne = s.find('1');
    return (firstOne == string::npos) ? "0" : s.substr(firstOne);
}

// This function adds two binary strings and return
// result as a third string
string addBinary(string &s1, string &s2) {
  
    // Trim leading zeros
    s1 = trimLeadingZeros(s1);
    s2 = trimLeadingZeros(s2);
  
    int n = s1.size();  
    int m = s2.size(); 
    
    // swap the strings if s1 is of smaller length
    if (n < m) {
        return addBinary(s2, s1);
    }
    
    int j = m - 1;  
    int carry = 0; 
    
    // Traverse both strings from the end
    for (int i = n - 1; i >= 0; i--) {
      
          // Current bit of s1
        int bit1 = s1[i] - '0';  
        int sum = bit1 + carry;
        
        // If there are remaining bits in s2, add them to the sum
        if (j >= 0) {
              
              // Current bit of s2
            int bit2 = s2[j] - '0';  
            sum += bit2;
            j--;
        }
        
        // Calculate the result bit and update carry
        int bit = sum % 2;
        carry = sum / 2;
        
        // Update the current bit in s1
        s1[i] = (char)(bit + '0');
    }
    
    // If there's any carry left, update s1
    if (carry > 0) {
        s1 = '1' + s1;
    }
    
    return s1;
}

int main() {
  
    string s1 = "1101", s2 = "111";
    cout << addBinary(s1, s2) << endl;
    return 0;
}
```

### day 15

Given a string ****s****, the task is to convert it into ****integer**** format without utilizing any built-in functions. Refer the below steps to know about [atoi()](https://www.geeksforgeeks.org/c-atoi-function/) function.

****Cases for atoi() conversion:****

- Skip any leading whitespaces.
- Check for a sign ('+' or '-'), default to positive if no sign is present.
- Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached. If no digits are present, return 0.
- If the integer is greater than ****2********31**** ****- 1,**** then return ****2********31**** ****- 1**** and if the integer is smaller than ****-2********31****, then return ****-2********31****.

****Examples:****

> ****Input:**** s = "-123"  
> ****Output: -****123
> 
> ****Input:**** s = " -"  
> ****Output:**** 0  
> ****Explanation:**** No digits are present, therefore 0.
> 
> ****Input:**** s = " 1231231231311133"  
> ****Output:**** 2147483647  
> ****Explanation:**** The converted number is greater than 231 - 1, therefore print 231 - 1 = 2147483647.
> 
> ****Input:**** s = "-999999999999"  
> ****Output:**** -2147483648  
> ****Explanation:**** The converted number is smaller than -231, therefore print -231 ****=**** -2147483648****.****
> 
> ****Input:**** s = " -0012gfg4"  
> ****Output:**** -12  
> ****Explanation:**** Nothing is read after -12 as a non-digit character 'g' was encountered.

****Algorithm:****

> The basic idea is to follow the ****atoi()**** algorithm in order and covering all the edge cases:
> 
> - Skip the leading whitespaces by iterating from the first character.
> - Now, check for at most one sign character ('+' or '-') and maintain a ****sign**** variable to keep track of the sign of the number.
> - Finally, read all the digits and construct the number until the first ****non-digit**** character is encountered or end of the input string is reached.
> - While constructing the number, if the number becomes greater than 231 - 1, print 231 - 1. Similarly, if the number becomes less than -231, print -231.

****How to check if the number is greater than 2********31**** ****- 1 or smaller than -2********31**** ****?****

The naive way is to use a data type which has size greater than ****32**** bits like ****long****, ****BigInteger**** to store the number. However, we can also use 32-bit integer by appending the digits one-by-one and for each digit, check if appending current digit to the number will make it underflow (****< -2********31****) or overflow(****>**** ****2********31********- 1****). While appending a digit to the current number, we can have 3 cases:

- ****Case 1: current number < (2********31**** ****- 1)/10 or current number > -2********31********/10:**** Simply append the digit to the current number as it won't cause overflow/underflow.
- ****Case 2: current number > (2********31**** ****- 1)/10 or current number < -2********31********/10:**** Return ****(2********31**** ****- 1)**** in case of overflow and ****-2********31**** in case of underflow.
- ****Case 3:**** ****current number = (2********31**** ****- 1)/10 or current number = -2********31********/10:**** In this case, if current number = (231 - 1)/10, then only ****0-7**** digits can be appended and if current number = -231/10, then only ****0-8**** digits can be appended.

In the below implementation, we are constructing the absolute value of the number, so we can simply compare with (231 - 1)/10 and avoid comparing with -231/10.
```cpp
// C++ Program to implement atoi() function

#include <iostream>
#include <limits.h>
using namespace std;

int myAtoi(char* s) {
    int sign = 1, res = 0, idx = 0;

    // Ignore leading whitespaces
    while (s[idx] == ' ') {
        idx++;
    }

    // Store the sign of number
    if (s[idx] == '-' || s[idx] == '+') {
          if(s[idx++] == '-')
          sign = -1;
    }

    // Construct the number digit by digit
    while (s[idx] >= '0' && s[idx] <= '9') {
        
        // handling overflow/underflow test case
        if (res > INT_MAX / 10 || (res == INT_MAX / 10 && s[idx] - '0' > 7)) {
            return sign == 1 ? INT_MAX : INT_MIN;
        }
      
        // Append current digit to the result
        res = 10 * res + (s[idx++] - '0');
    }
    return res * sign;
}

int main() {
    char s[] = "  -0012g4";
    cout << myAtoi(s);
    return 0;
}
```
