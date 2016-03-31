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
    ListNode* reverseList(ListNode* head) {
        if(head==NULL || head->next==NULL) return head;
        ListNode *preNode, *curNode, *nextNode;
        preNode = head;
        curNode = head->next;
        head->next = NULL;
        while(curNode) {
            nextNode = curNode->next;
            curNode->next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
};