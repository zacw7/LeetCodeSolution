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
    bool isPalindrome(ListNode* head) {
        ListNode *fast, *slow, *pre, *left, *right;
        fast = slow = head;
        left = right = pre = NULL;
        while(fast) {
            if (fast->next == NULL){
                left = pre;
                right = slow->next;
                break;
            } else if (fast->next->next == NULL) {
                right = slow->next;
                slow->next = pre;
                left = slow;
                break;
            } else {
                fast = fast->next->next;
                ListNode *temp = slow;
                slow = slow->next;
                temp->next = pre;
                pre = temp;
            }
        }
        
        while(left && right) {
            if(left->val != right->val) return false;
            left = left->next;
            right = right->next;
        }
        if(left||right) return false;
        else return true;
    }
};