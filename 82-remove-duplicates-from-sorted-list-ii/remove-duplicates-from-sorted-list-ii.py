class Solution:
    def deleteDuplicates(self, head: ListNode | None) -> ListNode | None:
        dummy = ListNode(0, head)
        prev = dummy
        curr = head

        while curr:
            # Duplicate group found
            if curr.next and curr.val == curr.next.val:
                duplicate_val = curr.val

                # Skip every node with this value
                while curr and curr.val == duplicate_val:
                    curr = curr.next

                prev.next = curr
            else:
                # Current value is unique
                prev = curr
                curr = curr.next

        return dummy.next
