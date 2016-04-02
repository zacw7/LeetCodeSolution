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
    ListNode* oddEvenList(ListNode* head) {
        if(head==NULL || head->next==NULL || head->next->next==NULL) return head;
        ListNode *oddHead, *evenHead, *oddNode, *evenNode;
        oddHead = oddNode = head;
        evenHead = evenNode = head->next; 
        while(oddNode&&evenNode) {
            if(evenNode->next) oddNode->next = evenNode->next;
            else break;
            oddNode=oddNode->next;
            if(oddNode) evenNode->next = oddNode->next;
            evenNode=evenNode->next;
        }
        oddNode->next=evenHead;
        return oddHead;
    }
};