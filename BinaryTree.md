#### Skills

* Traversal + global record. Make sure every subtree is called.



* Return Type

  * Be careful with base case



* Divide and Conquer (recursion) (most important)



* BFS (level-order traversal)



* Use graph algorithms (DFS)



* maintain a left boundary list



* non-recursive traversal skills (stack)
* bottom up using a recursive call
* When constructing a tree make sure empty tree is properly dealt



#### Caveat

* Null Pointer!!!
* Recursion End Condition
* Null Child



#### Problems

* Minimum Subtree
  * Global variable: minTree and minSum. Traverse the tree, if node == null, return 0 without comparing 0 with minSum. If node != null, compute the current sum, update the candidate for minSum and minTree. return the subtree sum.
* Post Order traversal
  * maintain a prev pointer and a stack. For each top node on the stack. First decide its relationship to the prev node. If the top node on the stack is a child of prev node. Push the left child or the right child if they exist. If the prev node is the left child of the prev node. That means we have finish visiting the left subtree. Push the right child on to the stack. Otherwise, either top == prev or top.right == prev. In both case, we just do "visit" the top node and pop it from the stack.
  * Another idea, use a stack. add node from the head of the result list
* In order traversal
  * Add the nodes on the left arm of the tree on the stack.
  * If the right child of the top node is not empty, add right and all of its left child to stack
  * If the right child is null. pop it. and Keep popping if the current node is the right child of the node on top of the stack. (because before visiting the left child, we have already visited the middle node.)
* Pre-Order traversal
  * Similar to BST, replace the queue with stack. Remember to add the right child on stack first.
* Populating Next Right Pointers in Each Node II
  * Maintain a list representing the next nodes for the current path
* Split BST

```java
List<TreeNode> split(TreeNode root, int val) {
  List<TreeNode> res = Arrays.asList(null, null);
  if(root == null) return res;
  if (root.val <= val) {
    res = split(root.right, val);
    root.right = res[0];
    res[0] = root;
  } else {
    res = split(root.left, val);
    root.left = res[1];
    res[1] = root;
  }
  return res;
}
```

* Binary Tree Paths
  * Use a DFS strategy
* Flatten Binary Tree to Linked List
  * Solve the problem recursively. Flatten both left and right subtrees. Cut the left subtree, connect it to the right branch. Traverse to the tail. Add the flattened right branch to the tail.
* Kth Smallest Element in a BST
  * HashMap to record the size of subtree O(n)
  * BST traversal O(k + h)
* Lowest Common Ancestor of a Binary Tree



* Validate Binary Search Tree

  * In-order traversal
  * recursion is not quite suitable

  ```java
  public boolean isValidBST(TreeNode root) {
  	return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  ```

* LCA I exist

  * if the root equals to A or B return root. Execute the function with left and right node. if both result is not empty return root.

* LCA may not exist

  * Craft a returnType is a very good strategy

* LCA with parent node

* Longest Consecutive sequence

  * For this kind of question. 最小的答案在全局中保存。小心有的子树没有得到执行的情况

  ```java
  int leftLen = dfs(node.left);
  int rightLen = dfs(node.right);
  ```

* Longest Consecutive sequence II

  ```java
  // return the longest increasing and decreasing path starting at node
  private int[] dfs(TreeNode node)
  ```

* Longest Consecutive sequence III

  * Almost the same with II

* Binary Tree Path Sum II

  * straight line down: depth first search. At each node, search the current path for a sublist ending at node with a sum equals to target. 

  ```java
  new ArrayList(path.subList(i, path.size()));
  ```

* get k closest nodes

  ```java
  private void getCurrentStack(TreeNode root, double target, Deque<TreeNode> stack) {
  	TreeNode cur = root;
  	while (cur != null) {
  		stack.addFirst(cur);
  		if(target <= cur.val) {
  			cur = cur.left;
  		} else {
  			cur = cur.right;
  		}
  	}
  }
  ```

* Find Leaves of Binary Tree


    * Closely related to Height function. Traversal, find the height from bottom of each node. Then add itself to the result.

* Binary Tree Upside Down

    * Maintain the tail Node. Return the head node. Do it recursively.

* build boundary


    * Read the question carefully to understand the definition of left and right boundary. Then call the recursive function on the left and right child of the root to collect left and right boundaries.

* Binary Tree Path Sum III


    * Brute Force search. Try all starting point. For each starting point, try every ending point. Use two level of traversal by using two helper functions. 
    * First level : driver(node, res).   Second level: dfs(sum, target, prev, cur, path, res);

* Construct from inorder postorder


    * recursion on different starting index and length

* Unique Binary Search Trees II


  * This problem is very tricky. Very each to make a mistake. 
  * n equals zero, return an empty list
  * if start > end, return an list containing the null pointer

* Recover Binary Search Tree


  * In-order traversal. 
  * The first pair of inverse. prev.val > cur.val if(first == null) first = prev; second = cur
  * The second pair of inverse. prev.val > cur.val second = cur;

* Binary Tree Cameras


  * Start from the bottom. Recursively. Used a set to record covered nodes. Add null in it.
  * If cur has no parent and it is not covered---add it
  * If left child of cur is not covered --- add it
  * If right child of cur is not covered --- add it

```java
class Solution {
    private int camera;
    private Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        this.camera = 0;
        this.covered = new HashSet();
        this.covered.add(null);
        
        dfs(root, null);
        return this.camera;
    }
    
    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);
            
            if(needCover(node, par)) {
                this.camera++;
                this.covered.add(node);
                this.covered.add(par);
                this.covered.add(node.left);
                this.covered.add(node.right);
            }
        }
    }
    private boolean needCover(TreeNode node, TreeNode par) {
        if (par == null && !this.covered.contains(node)) {
            return true;
        } else if(!this.covered.contains(node.left)) {
            return true;
        } else if(!this.covered.contains(node.right)) {
            return true;
        } else {
            return false;
        }
    }
}
```

