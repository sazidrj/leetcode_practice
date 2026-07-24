/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class cmp{
    public:
    
            bool operator()(ListNode* l1, ListNode* l2){
                return l1->val > l2->val;
            }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* ans = new ListNode(0);
        ListNode* it = ans;
        
        priority_queue<ListNode*, vector<ListNode*>, cmp> q;
        
        for(int i = 0; i<lists.size(); i++){
            if(lists[i] != NULL){
                q.push(lists[i]);
            }
        }  
        
        while(!q.empty()){
            ListNode* minNode = q.top();
            it->next = minNode;
            it = it->next;
            q.pop();
            if(minNode->next != NULL)
                q.push(minNode->next);
        }
        
        return ans->next;
        
    }
};