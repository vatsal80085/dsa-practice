https://www.codechef.com/practice/strings

### DNA Storage

For encoding an even-length binary string into a sequence of `A`, `T`, `C`, and `G`, we iterate from **left to right** and replace the characters as follows:

- `00` is replaced with `A`
- `01` is replaced with `T`
- `10` is replaced with `C`
- `11` is replaced with `G`
Given a binary string SS of length NN (NN is even), find the encoded sequence.

Input Format

- First line will contain TT, number of test cases. Then the test cases follow.
- Each test case contains two lines of input.
- First line contains a single integer NN, the length of the sequence.
- Second line contains binary string SS of length NN.

Output Format
For each test case, output in a single line the encoded sequence


```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string s;
        cin>>s;
        string ans="";
        // your code goes here
        int i=0;
        while(i<n){
            if(s[i]=='0' && s[i+1]=='0'){
                ans+="A";
            }
            if(s[i]=='0' && s[i+1]=='1'){
                ans+="T";
            } 
            if(s[i]=='1' && s[i+1]=='0'){
                ans+="C";
            }
            if(s[i]=='1' && s[i+1]=='1'){
                ans+="G";
            }
            i+=2; //did not take +1 because the index would come to be out                      of range
        }
        
        cout<<ans<<endl;
        
    }

}
```



### Wordle

Chef invented a modified wordle.

There is a hidden word SS and a guess word TT, both of length 55.

Chef defines a string MM to determine the correctness of the guess word. For the ithith index:

- If the guess at the ithith index is correct, the ithith character of MM is GG.
- If the guess at the ithith index is wrong, the ithith character of MM is BB.

Given the hidden word SS and guess TT, determine string MM.

 Input Format

- First line will contain TT, number of test cases. Then the test cases follow.
- Each test case contains of two lines of input.
- First line contains the string SS - the hidden word.
- Second line contains the string TT - the guess word.

Output Format

For each test case, print the value of string MM.

You may print each character of the string in uppercase or lowercase (for example, the strings BgBgBBgBgB, BGBGBBGBGB, bgbGBbgbGB and bgbgbbgbgb will all be treated as identical).
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--){
	    string S;
	    cin>>S;
	    string T;
	    cin>>T;
	    int i=0;
	    string ans="";
	    while(i<5){
	        if(S[i]==T[i]){
	            ans+="G";
	        }
	        else{
	            ans+="B";
	        }
	        i+=1;
	    }
	    cout<<ans<<endl;
	}

}
```


### Different Consecutive Characters

Chef has a binary string SS of length NN. Chef can perform the following operation on SS:

- Insert any character (00 or 11) at any position in SS.

Find the minimum number of operations Chef needs to perform so that no two consecutive characters are same in SS.

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--){
	    int len;
	    cin>>len;
	    string str;
	    cin>>str;
	    int count=0;
	    int i=0;
	    while(i<len){
	        if(str[i]==str[i+1]){
	            count++;
	        }
	        i+=1;
	    }
	    cout<<count<<endl;
	}

}
```

### Convert String to Title Case
Given a string `S` consisting of only lowercase and uppercase English letters and spaces, your task is to convert it into title case. In title case, the first letter of each word is capitalized while the rest are in lowercase, except for words that are entirely in uppercase (considered as acronyms), which should remain unchanged.
**Note:**
- Words are defined as contiguous sequences of English letters separated by spaces.
- Acronyms are words that are entirely in uppercase and should remain unchanged.
- Assume the input does not contain leading, trailing, or multiple spaces between words.
Input Format
- The first line contains a single integer `T`, the number of test cases.
- Each of the next `T` lines contains a string `S`.
Output Format
For each test case, print a single line containing the string `S` converted into title case.

```cpp
#include <bits/stdc++.h> // Includes all standard library headers
using namespace std;

int main() {
    int T; // Number of test cases
    cin >> T; // Read the number of test cases
    cin.ignore(); // Clear the input buffer after reading T to handle newline characters

    while (T--) { // Loop through each test case
        string s; // Declare a string to store the input sentence
        getline(cin, s); // Read the entire line, including spaces, into the string

        int n = s.size(); // Get the size of the string

        // Loop through each character in the string
        for (int i = 0; i < n; i++) {
            // Check if the current character is the first in the string or follows a space
            if (i == 0 || s[i - 1] == ' ') {
                s[i] = toupper(s[i]); // Convert the character to uppercase
            }
            // Otherwise, check if the current character is uppercase and adjacent to lowercase letters
            else if (isupper(s[i]) && (islower(s[i + 1]) || islower(s[i - 1]))) {
                s[i] = tolower(s[i]); // Convert the character to lowercase
            }
        }

        cout << s << endl; // Output the modified string
    }

    return 0; // End of program
}

```


### World Chess Championship

The World Chess Championship 2022 is about to start. 14 Classical games will be played between Chef and Carlsen in the championship, where each game has one of three outcomes — it can be won by Carlsen, won by Chef, or it can be a draw. The winner of a game gets 2 points, and the loser gets 0 points. If it’s a draw, both players get 1 point each.

The total prize pool of the championship is 100⋅X. At end of the 14 Classical games, if one player has **strictly more** points than the other, he is declared the champion and gets 60⋅X60⋅X as his prize money, and the loser gets 40⋅X.

If the total points are **tied**, then the defending champion Carlsen is declared the winner. However, if this happens, the winner gets only 55⋅X, and the loser gets 45⋅X.

Given the results of all the 14 games, output the prize money that Carlsen receives.
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
	// your code goes here
	int t, points_carlsen=0, points_chef=0;
	
	cin>>t;
	while(t--){
	    int x;
	    string str;
	    cin>>x>>str;
	    int carl_win=0, chef_win=0,drew=0;
	    for(int i=0; i<14; i++){
	        if(str[i]=='C'){
	            carl_win++;
	        }
	        if(str[i]=='N'){
	            chef_win++;
	        }
	        if(str[i]=='D'){
	            drew++;
	        }
	    }
	    points_carlsen = 2*carl_win + 1*drew;
	    points_chef = 2*chef_win + 1*drew;
	    if(points_chef < points_carlsen){
	        cout<<60*x<<endl;
	    }
	    if(points_chef > points_carlsen){
	        cout<<40*x<<endl;
	    }
	    if(points_chef == points_carlsen){
	        cout<<55*x<<endl;
	    }
	}
}

```

### Add One

You are given a large number NN. You need to print the number N+1.

Note: The number is very large and it will not fit in standard integer data type. You have to take the input as String and then manipulate the digits to convert it to N+1.
To add one to a very large number represented as a string (which could exceed the limits of numerical types in some programming languages), you can use string manipulation.

```cpp
#include <bits/stdc++.h>
using namespace std;

string addOneToLargeNumber(const string& numStr) {
    string result = numStr; // Make a copy of the input string
    int n = result.size();
    // Start from the least significant digit
    for (int i = n - 1; i >= 0; --i) {
        if (result[i] == '9') {
            // If the digit is 9, set it to 0
            result[i] = '0';
        } else {
            // Increment the digit and break
            result[i] += 1;
            return result;
        }
    }
    // If all digits were 9, we need to add a leading '1'
    return "1" + result;
}
int main() {
    int t;
    cin>>t;
    while(t--){
        string largeNumber;
        cin>>largeNumber;
        string result = addOneToLargeNumber(largeNumber);
        cout << result << endl; // Output: 10000000000000000000000000000000000
    }
    return 0;
}
```


### Chef and Happy String

Chef has a string SS with him. Chef is happy if the string contains a **contiguous substring** of length **strictly greater** than 22 in which all its characters are vowels.
Determine whether Chef is happy or not.
In English alphabet, vowels are `a`, `e`, `i`, `o`, and `u`.
 Input Format
- First line will contain TT, number of test cases. Then the test cases follow.
- Each test case contains of a single line of input, a string SS.
Output Format
For each test case, if Chef is happy, print `HAPPY` else print `SAD`.

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int t, c=0;
    cin>>t;
    while(t--){
        string s;
        cin>>s;
        // your code goes here
        for(int i=0; i<s.length(); i++){
            if(s[i]=='a' || s[i]=='e'|| s[i]=='i'|| s[i]=='o' || s[i]=='u'){
                c++;
                if(c==3){
                   cout<<"Happy\n";
                   break; 
                } 
            }
            else c=0;
        }
         if(c!=3) cout<<"Sad"<<endl;      
    }

}
```


### Blobby Volley Scores
Alice and Bob are playing a game of [Blobby Volley](https://blobbyvolley.de/data/bv2browser/index.html). In this game, in each turn, one player is the server and the other player is the receiver. Initially, Alice is the server, and Bob is the receiver.
If the server wins the point in this turn, their score increases by 1, and they remain as the server for the next turn.  
But if the receiver wins the point in this turn, their score does not increase. But they become the server in the next turn.  
In other words, your score increases only when you win a point when you are the server.  
Please see the Sample Inputs and Explanation for more detailed explanation.

They start with a score of 00 each, and play NN turns. The winner of each of those hands is given to you as a string consisting of 'A's and 'B's. 'A' denoting that Alice won that point, and 'B' denoting that Bob won that point. Your job is the find the score of both of them after the NN turns.
Input Format
- The first line of input will contain a single integer TT, denoting the number of test cases.
- Each test case consists of two lines of input.
    - The first line of each test case contains one integer NN — the number of turns.
    - The line contains a string SS of length NN.
        - If the ith character of this string is 'A', then Alice won that point.
        - If the ith character of this string is 'B', then Bob won that point.
Output Format
For each test case, output on a new line, two space-separated integers - Alice's final score, and Bob's final score.

```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int t;
    cin>>t;
    while(t--){
        int n, a=0, b=0;
        cin>>n;
        string s;
        cin>>s;
        // your code goes here
        if(s[0]=='A'){
            a++;
        }
        for(int i=0; i<n; i++){
            
            if(s[i]=='A' && s[i+1]=='A'){
                
                a++;  
            } 
            else if(s[i]=='B' && s[i+1]=='B'){
                
                b++;
            }
        }
        cout<<a<<" "<<b<<endl;
    }

}

```


### Leetcode 1422

Complexity

- Time complexity: O(n)

- Space complexity: O(1)

```cpp
class Solution {
public:
    int maxScore(string s) {
            int maxScore = 0;
            int once = 0;
            int zero = 0;
            for(int i = 0;i<s.length();i++){
               if(s[i]=='1'){
                    once++;
               }
            }

        for(int i = 0;i < s.length() - 1;i++){
            if(s[i]=='0'){
                zero+=1;
                maxScore = max(zero+once,maxScore); 
            }
        else{
            if(once>=1){
            once-=1;
        }
        maxScore = max(zero+once,maxScore);
        }
   }
   return maxScore;
}

};
```