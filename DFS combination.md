#### skills



* deal with base case

`if(idx == nums.length) return`



* recursive calls are in a loop

```java
for (int i = idx; i < n; i++) {
  dfs(i + 1, part, list, res);
}
```



* choose parameters wisely

  * represent current state
  * decompose the original problem

  ​

* get rid of duplicate

`if (i > index && nums[i] == nums[i - 1])`

* template

```java
public List<List<String>> function(String s) {
        List<List<String>> res = new ArrayList();
        List<String> palindrome = new ArrayList();
        
        dfs(0, s, palindrome, res);
        return res;
    }
private dfs(int index, 
            String input, 
            int partialInfo,
            List<String> oneRes, 
            List<List<String>> results) 
{
	// if every node is a fit
  	res.add(oneRes);
  
  	// if only the complete path is a fit
  	if (idx == n) {
    	res.add(new ArrayList(oneRes));	
  	}
  	
  
  	// 这里选择的是头部时inclusive, 尾部时exclusive
  	for (int i = idx; i < n; i++) {
    	// choose the next starting point
  	}
}
```



#### caveat

* prefer array to map
* prefer exclusive ending index



#### questions

* Palindrome Partitioning
  * private function isPalindrome

* Palindrome Partitioning II
  * Corner case`if(idx == s.length())  return -1;`
  * Must manually go through three test cases

* Given an array contains *N* numbers of 0 .. *N*, find which number doesn't exist in the array
  * xor all elements.
  * xor the result with number 0 ... N

* word break

  * dp[i] substring(i) can be decomposed into Strings existing in dict
  * for(int i = idx; i < n; i++)  String cur = s.substring(idx, i + 1);

* word break II

  * Since a List of String is involved, making the solution more complicated
  * memo[0].add("");
  * exclusive boundary end

* word break III

  * base case

* Regular Expression Match

  * `match(String s, String p, int sidx, int pidx)`
  * `if (sidx == slen && pidx == plen) return true`
  * `if (pidx == plen) return false`
  * `if (pidx < plen - 1 && p.charAt(pidx + 1) == '*')`
  * `else if (sidx == slen) return true;`
  * `if (matchAtChar(s, p, sidx, pidx)) return dfs(s, p, sidx + 1, pidx + 1);`
  * `return false`

* Wild Card Matching

  * The most import thing: what are you computing! 
  * `dp[i][j] represent if substring(0, i) and substring(0, j) match `
  * `initialize when i = 0 and j = 0`

  ```java
    int idx = 0;
    while(idx < plen && p.charAt(idx) == '*') {
      dp[0][idx + 1] = true;
      idx++;
    }
  ```

  * three branches

  ```java
  if(p.charAt(j-1) == '*') {
  	dp[i][j] = dp[i][j - 1] || dp[i-1][j];
  }
  ```

  * Be very careful please

* Find missing value II

  * `Set<Integer> numbers = new HashSet<>();`
  * `Set<Integer> existNum= new HashSet<>();`
  * be careful of 09, 08, 07

* Factorization

  * factors in non-descending order
  * cannot be the original number itself

* Restore IP Addresses

* Generate Parentheses

* Remove Invalid Parentheses

* Decode Way

* Decode Way II

* Edit distance

* Add Operator

