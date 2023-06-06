/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
Intuition
First create a function to reverse linked list
then call function (size of linked list)/k times

Approach
Create Reverse function which accepts current node and end node
In reverse function:
->Implement it using your approch just make prev = end and not null

In base function:
-> run while loop for linked list
-> run another nested while loop till i<k to find end(till when the nodes will be reversed)
-> then just call reverse(current, end)

Complexity
Time complexity: O(n)

Space complexity: O(1)
*/

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode newHead = head;
        while (cur != null) {
            int i = 0;
            ListNode end = cur;  // in need to check for end always start from cur and go upto k length
            // find the end
            while (end != null && i < k) {
                end = end.next;
                i++;
            }
            if (i == k) {
                if (cur == head) {              
                    newHead = reverse(cur, end); // cur is at 1 end is at 3
                } else {
                    prev.next = reverse(cur, end); // in second run we are making 1 -> next = 4
                }
            }

            prev = cur;  // prev = 1 , in second run prev = 3 
            cur = end;   // cur = 3  , in second run cur = 5
            // the last two lines are not valid for length < k since cuur next is already pointing to prev in the reverse function
        }

        return newHead;
    }

    public ListNode reverse(ListNode cur1, ListNode end) {
        ListNode prev = end; // cannot do prev = null this won't print the left over elements, also doing it because first node previous should be the end one and not null
        ListNode cur = cur1;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    void print(ListNode head) {
        System.out.println("");
        ListNode cur = head;
        while (cur != null) {
            System.out.print(" " + cur.val);
            cur = cur.next;
        }
    }
}
