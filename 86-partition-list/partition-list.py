
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def partition(self, head: ListNode | None, x: int) -> ListNode | None:
        less = ListNode(0)
        greater = ListNode(0)

        less_tail = less
        greater_tail = greater

        curr = head

        while curr:
            if curr.val < x:
                less_tail.next = curr
                less_tail = less_tail.next
            else:
                greater_tail.next = curr
                greater_tail = greater_tail.next

            curr = curr.next

        greater_tail.next = None
        less_tail.next = greater.next

        return less.next
