
### day 20 Minimum Characters to Add at Front for Palindrome

Given a string ****s,**** the task is to find the ****minimum**** number of characters to be added to the front of ****s**** to make it ****palindrome****. A ****palindrome string**** is a sequence of characters that reads the same forward and backward.

****Examples:**** 

> ****Input****: s = "abc"  
> ****Output****: 2  
> ****Explanation****: We can make above string palindrome as "cbabc", by adding 'b' and 'c' at front.  
>   
> ****Input****: str = "aacecaaaa"  
> ****Output****: 2  
> ****Explanation****: We can make above string palindrome as "aaaacecaaaa" by adding two a's at front of string.

```cpp
// C++ program for getting minimum character to be
// added at front to make string palindrome

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

vector<int> computeLPSArray(string &pat) {
    int n = pat.length();
    vector<int> lps(n);

    // lps[0] is always 0
    lps[0] = 0;
    int len = 0;

    // loop calculates lps[i] for i = 1 to M-1
    int i = 1;
    while (i < n) {

        // If the characters match, increment len
        // and set lps[i]
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        }

        // If there is a mismatch
        else if (pat[i] != pat[len]) {

            // If len is not zero, update len to
            // the last known prefix length
            if (len != 0) {
                len = lps[len - 1];
            }

            // No prefix matches, set lps[i] to 0
            else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

// Method returns minimum character to be added at
// front to make string palindrome
int minChar(string &s) {
    int n = s.length();
    string rev = s;
    reverse(rev.begin(), rev.end());

    // Get concatenation of string, special character
    // and reverse string
    s = s + "$" + rev;

    //  Get LPS array of this concatenated string
    vector<int> lps = computeLPSArray(s);

    // By subtracting last entry of lps vector from
    // string length, we will get our result
    return (n - lps.back());
}

int main() {
    string s = "AACECAAAA";
    cout << minChar(s);
    return 0;
}
```
### day 19 KMP Algorithm for Pattern Searching

---

Given two strings ****txt**** and ****pat, t****he task is to return all indices of ****occurrences**** of ****pat**** within ****txt****.

****Examples:****

> ****Input:**** txt = "abcab", pat = "ab"  
> ****Output:**** [0, 3]  
> ****Explanation****: The string "ab" occurs twice in txt, first occurrence starts from index 0 and second from index 3.
> 
> ****Input:**** txt=  "aabaacaadaabaaba", pat =  "aaba"  
> ****Output:**** [0, 9, 12]  
> ****Explanation:****
> 
> [caption width="800"]![kmp-algorithm-for-pattern-searching](https://media.geeksforgeeks.org/wp-content/uploads/20241101095406060645/kmp-algorithm-for-pattern-searching.webp)

```cpp
// C++ program to search the pattern in given text using
// KMP Algorithm

#include <iostream>
#include <string>
#include <vector>
using namespace std;

void constructLps(string &pat, vector<int> &lps) {

    // len stores the length of longest prefix which
    // is also a suffix for the previous index
    int len = 0;

    // lps[0] is always 0
    lps[0] = 0;

    int i = 1;
    while (i < pat.length()) {

        // If characters match, increment the size of lps
        if (pat[i] == pat[len]) {
            len++;
            lps[i] = len;
            i++;
        }

        // If there is a mismatch
        else {
            if (len != 0) {

                // Update len to the previous lps value
                // to avoid reduntant comparisons
                len = lps[len - 1];
            }
            else {

                // If no matching prefix found, set lps[i] to 0
                lps[i] = 0;
                i++;
            }
        }
    }
}

vector<int> search(string &pat, string &txt) {
    int n = txt.length();
    int m = pat.length();

    vector<int> lps(m);
    vector<int> res;

    constructLps(pat, lps);

    // Pointers i and j, for traversing
    // the text and pattern
    int i = 0;
    int j = 0;

    while (i < n) {

        // If characters match, move both pointers forward
        if (txt[i] == pat[j]) {
            i++;
            j++;

            // If the entire pattern is matched
            // store the start index in result
            if (j == m) {
                res.push_back(i - j);

                // Use LPS of previous index to
                // skip unnecessary comparisons
                j = lps[j - 1];
            }
        }

        // If there is a mismatch
        else {

            // Use lps value of previous index
            // to avoid redundant comparisons
            if (j != 0)
                j = lps[j - 1];
            else
                i++;
        }
    }
    return res;
}

int main() {
    string txt = "aabaacaadaabaaba";
    string pat = "aaba";

    vector<int> res = search(pat, txt);
    for (int i = 0; i < res.size(); i++)
        cout << res[i] << " ";

    return 0;
}
```
### day 18 Find first non-repeating character of given string

Given a string ****s**** of ****lowercase**** English letters, the task is to find the ****first non-repeating**** character. If there is no such character, return ****'$'****.

****Examples:**** 

> ****Input:**** s = "geeksforgeeks"  
> ****Output: '****f'  
> ****Explanation:**** 'f' is the first character in the string which does not repeat.
> 
> ****Input:**** s = "racecar"  
> ****Output: '****e'  
> ****Explanation:**** 'e' is the only character in the string which does not repeat.
> 
> ****Input:**** "aabbccc"  
> ****Output:**** '$'  
> ****Explanation:**** All the characters in the given string are repeating.

```cpp
// C++ program to find the index of the first
// non repeating character using nested loop

#include <iostream>
using namespace std;

// Function to find the index of the first 
// non-repeating character
char nonRepeatingChar(string &s) {
    int n = s.length();

    // Iterate over each character in the string
    for (int i = 0; i < n; ++i) {
        bool found = false;

        // Check if the character repeats in the
        // rest of the string
        for (int j = 0; j < n; ++j) {
            if (i != j && s[i] == s[j]) {
                found = true;
                break;
            }
        }

        // If character does not repeat, return it
        if (found == false) 
            return s[i];
    }

    // If no such character is found, return '$'
    return '$';
}

int main() {
    string s = "racecar";
  
    cout << nonRepeatingChar(s);
    return 0;
}
```
### day17 Anagrams Strings
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
