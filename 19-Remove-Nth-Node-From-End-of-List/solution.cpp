/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head==NULL || head->next==NULL) return NULL;
        ListNode *fast, *slow;
        fast = slow = head;
        while(n--) {
            fast = fast->next;
        }
        if(fast==NULL) return head->next;
        while(fast->next) {
            fast = fast->next;
            slow = slow->next;
        }
        if(slow->next) slow->next = slow->next->next;
        else slow = NULL;
        return head;
    }
};