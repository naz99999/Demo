package linkedList;

public class LL {

    private Node head;

    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LL() {
        this.size = 0;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node() {

        }
    }

    public void display() {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    private Node insertRec(int value, int index, Node node) {
        if(index==0) {
            Node newNode = new Node(value, node);
            size++;
            return newNode;
        }

        node.next = insertRec(value, index-1, node.next);
        return node;
    }


    public void insertFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int value) {
        Node newNode = new Node(value);

        //another approach
//        if(tail == null) {
//            insertFirst(value);
//            return;
//        }
//        Node newNode = new Node(value);
//        tail.next = newNode;
//        newNode.next = null;
//        tail = tail.next;

        if(head == null) {
            head = newNode;
            newNode.next = null;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = null;
            tail = tail.next;
        }
        size++;
    }

    public void insertAtNth(int index, int value) {
        if(index==0) {
            insertFirst(value);
            return;
        }
        if(index==size) {
            insertLast(value);
            return;
        }
        if(index<size) {
            int count = 0;
            Node temp = head;
            Node newNode = new Node(value);
            while (count != (index - 1)) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;

            size++;
        }
    }

    //Questions

    //Merge Sorted LLs
    public Node mergeLinkedLists(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        Node dummyHead = new Node();
        Node tail = dummyHead;

        while(curr1!=null && curr2!=null) {
            if(curr1.value > curr2.value) {
                tail.next = curr1;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
        }

        while (curr1!=null) {
            tail.next = curr1;
            curr1 = curr1.next;
            tail = tail.next;
        }

        while (curr2!=null) {
            tail.next = curr2;
            curr2 = curr2.next;
            tail = tail.next;
        }

        return dummyHead.next;
    }

    //Remove duplicates
    public void removeDuplicates() {
        Node curr = head;
        while(curr.next!=null) {
            if(curr.value == curr.next.value) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    private Node insertRec2(int value, int index, Node node) {
        if(index==0) {
            Node newNode = new Node(value, node.next);
            node.next = newNode;
            size++;
            return node;
        }

        node.next = insertRec2(value, index-1, node.next);
        return node;
    }

    //Recursive insert
    public void recursiveInsert(int value, int index) {
        //head = insertRec(value, index, head);
        head = insertRec2(value, index-1, head);
    }

    //Cycle detection
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null || fast.next != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    //Cycle Length
    public int cycleLength(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null || fast.next != null) {
            if (fast == slow) {
                //calculate the length
                int length = 0;
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
                return length;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return 0;
    }

    //Find the start of the LL cycle
    public Node findCycleStart(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;

        while (fast != null || fast.next != null) {
            if (fast == slow) {
                //calculate the length
                do {
                    slow = slow.next;
                    length++;
                } while (slow != fast);
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        //slow = head;

//        while (length>0) {
//            slow = slow.next;
//            length--;
//        }

        while (fast!=slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    //Happy Number
    public boolean happyNumber(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(n);
            fast = sumOfSquares(sumOfSquares(n));
            if(fast==1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n>0) {
            int digit = n%10;
            sum = sum + digit*digit;
            n = n/10;
        }
        return sum;
    }

    //Middle of LL
    public Node middleOfLL(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node getMidTillNull(Node head) {
        Node midPrev = null;
        while (head!=null || head.next!=null) {
           if(midPrev==null) {
               midPrev = head;
           } else {
               midPrev = midPrev.next;
           }
           head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public Node mergeSort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Node mid = getMidTillNull(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return mergeLinkedLists(left, right);
    }

    //Reverse by recursion
    public Node reverseRecursion(Node head) {
        Node tail = head;
        while(tail.next!=null) {
            tail = tail.next;
        }

        reverseRec(head);
        return tail;
    }

    public void reverseRec(Node node) {
        if(node == tail) {
            head = tail;
            return;
        }
        reverseRec(node.next);

        tail.next = node;
        node.next = null;
        tail = node;
    }

    //Reverse by Iteration
    public void reverseLL(Node node) {
        Node prev = null;
        Node present = node;
        Node next = node.next;

        while (present!=null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;
    }

    //Reverse by Iteration Left Right
    public void reverseLeftRightLL(Node node, int left, int right) {

    }

}