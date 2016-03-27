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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if(m==n) return head;
        ListNode *nodeOfM, *nodeOfN;
        nodeOfM = nodeOfN = head;
        ListNode *preNodeOfM = NULL;
        if(m>1) {
            m--;
            preNodeOfM = head;
            while(--m) preNodeOfM = preNodeOfM->next;
            nodeOfM = preNodeOfM->next;
        }
        while(--n) nodeOfN = nodeOfN->next;
        if(preNodeOfM) preNodeOfM->next = nodeOfN;
        else head = nodeOfN;
        ListNode *preNode, *curNode, *nextNode;
        preNode = nodeOfM;
        curNode = preNode->next;
        nodeOfM->next = nodeOfN->next;
        while(preNode!=nodeOfN) {
            nextNode = curNode->next;
            curNode->next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return head;
    }
};