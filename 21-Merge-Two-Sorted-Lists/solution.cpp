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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *head, *node;
        if(l1&&l2) {
            if(l1->val < l2->val) {
                head = l1;
                l1 = l1->next;
            } else {
                head = l2;
                l2 = l2->next;
            }
        }
        else if(l1) return l1;
        else if(l2) return l2;
        else return NULL;
        node = head;
        while(l1&&l2) {
            if(l1->val < l2->val) {
                node->next = l1;
                l1 = l1->next;
            } else {
                node->next = l2;
                l2 = l2->next;
            }
            node = node->next;
        }
        if(l1) node->next = l1;
        if(l2) node->next = l2;
        return head;
    }
};