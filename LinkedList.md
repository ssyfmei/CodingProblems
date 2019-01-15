#### Skills

* Skill one (reverse list)
  * Insert to tail
  * Insert to head (after the dummyHead)



* Skill two (fast, slow pointers)





* Skill three (A-B  ---> AABB)


  * First pass: clone each node
  * Second pass: set up random pointer of cloned nodes
  * Take out the cloned nodes
  * Take care of null random pointer

  ​

* Skill four (two pass)



* Skill five (Dummy head)

```java
ListNode head = new ListNode(0);
ListNode tail = head;
```



* Skill six (not in place)

```JAVA
ListNode headOfLarge = new ListNode(0), tailOfLarge = headOfLarge;
ListNode headOfSmall = new ListNode(0), tailOfSmall = headOfSmall;
```



* Skill seven (change value of a node)

```java
public void deleteNode(ListNode node) {
	node.val = node.next.val;
  	node.next = node.next.next;
}
```



* caveat 
  * When do the inserting, remember to draw a graph and make sure all nodes are dealt properly
  * Record temporary nodes
  * Use prev, cur, next to name the nodes
  * Ask questions to clarify the problem
    * Is there a circle?
    * Is it a single linked list or a double linked list?
    * Is it required to do it in place?
    * is it allowed to change the value of a node?





* Questions (one sentence solution)

  * Merge k Sorted Lists 

    * At first, put the first node of each list into a priorityQueue. Poll the smallest node out and add the tail of the result list. Add the next node of smallest node into the PQ. Repeat the process.

  * Reverse Nodes in k-Group

    * Write a helper function to decide if there are still k nodes after the given node. If so, add these k nodes to the head in order. If not, add these remaining nodes to the tail in order.

  * Rotate List

    * Go through the list to record the length n. Let a pointer go the the new tail. Keep adding nodes retrieved from tail to head.

  * Copy List with Random Pointer

    * Clone each node and add the cloned node to the next of the original node. Set up the random pointer correctly. Take out the cloned node to compose a result list.

  * Insert into a cyclic List

    * If the node is null. Build a new node and make it cyclic. If all the nodes on the circle have the same value. Insert the node at any position. Write a helper function insertAfter

  * Sort List

    * Use a fast, slow pointer strategy. A prev pointer to record the node before slow. Set prev.next to null to divide the original list into two separate lists. Sort these two list respectively. Merge the result. Don't forget to deal with the base case where there is only one node on the list.

  * Reverse Linked List II

    * Go to the (m - 1) node of the list. This node is the head for following insertion. The node right after it is the tail for following insertion.  Keep adding the next node of insertTail to the right of insertHead. If n < m throw exception. If n == m return immediately.

  * Remove Nth Node From End of List

    * DummyHead,  a faster pointer is (n + 1) step ahead of a slower pointer. When the faster pointer is null, the slower pointer is the (n + 1) th pointer.  Remove the node right after the slow pointer.

  * Partition List

    * headOfLarge, headOfSmall, tailOfLarge, tailOfSmall

      Go through the list, if smaller than val, add to large list otherwise, add to the small list. Combine these two lists.

  * Palindrome Linked List

    * fast and slow pointers. Reverse.

  * Remove Linked List Elements

    * If the next node is with value val, remove the next node. Otherwise, increment the pointer.

  * Plus one

  ```java
  while (cur.next != null) {
  	if(cur.val != 9 && cur.next.val == 9) {
  		pos = cur;
  	}
  	cur = cur.next;
  }
  ```

  ​