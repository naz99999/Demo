package linkedList;

public class InterviewQues {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val;this.next = next;}
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;

        while (present!=null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode middleOfLL(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;

        for(int i=0; curr!=null && i<left-1; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode beforeStart = prev;
        ListNode newEnd = curr;

        ListNode next = curr.next;
        for(int i=0; curr!=null && i<right-left+1; i++) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (beforeStart!=null) {
            beforeStart.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) {
            return false;
        }
        ListNode head2 = new ListNode(head.val);
        ListNode temp = head.next;
        ListNode temp2 = head2;

        while (temp!=null) {
            ListNode newNode = new ListNode(temp.val);
            temp2.next = newNode;
            temp2 = temp2.next;
            temp = temp.next;
        }
        temp2.next = null;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;

        while (present!=null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;

        temp = head;
        temp2 = head2;

        while (temp!=null) {
            if (temp.val != temp2.val) {
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {

        ListNode mid = middleOfLL(head);
        ListNode secondHead = reverseLL(mid);
        ListNode reReverseHead = secondHead;

        //compare both halves
        while (head!=null && secondHead!=null) {
            if (head.val != secondHead.val)
                break;
            secondHead = secondHead.next;
            head = head.next;
        }

        reverseLL(reReverseHead);

        return head == null || secondHead == null;
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleOfLL(head);
        ListNode secondHead = reverseLL(mid);
        ListNode firstHead = head;


        while (secondHead!=null && firstHead!=null) {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if (firstHead!= null) {
            firstHead.next = null;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode beforeStart = prev;
            ListNode newEnd = curr;
            ListNode next = curr.next;
            //run for k times
            for (int i = 0; i < k; i++) {
                //for the last remaining group
                if (curr==null) {
                    ListNode reverseTill = beforeStart;
                    curr = prev;
                    prev = null;
                    next = curr.next;
                    while (curr!=reverseTill) {
                        curr.next = prev;
                        prev = curr;
                        curr = next;
                        if (next != reverseTill) {
                            next = next.next;
                        }
                    }
                    curr.next = prev;
                    return head;
                }
                //reversal for k groups
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (beforeStart != null) {
                beforeStart.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
        }
        return head;
    }

    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode beforeStart = prev;
            ListNode newEnd = curr;
            ListNode next = curr.next;
            //run for k times
            for (int i = 0; i < k; i++) {
                //reversal for k groups
                curr.next = prev;
                prev = curr;
                curr = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (beforeStart != null) {
                beforeStart.next = prev;
            } else {
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;

            //skip k nodes
            for (int i=0; curr!=null && i<k; i++) {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) {
            return null;
        }

        ListNode tail = head;
        int length = 1;

        while (tail.next!=null) {
            tail = tail.next;
            length++;
        }

        ListNode last = head;
        int times = length - (k%length) - 1;
        for (int i=0; i<times; i++) {
            last = last.next;
        }

        tail.next = head;
        head = last.next;
        last.next = null;

        return head;
    }

}
