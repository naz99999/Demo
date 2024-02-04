package linkedList;

import linkedList.LL;
import org.w3c.dom.Node;

public class LLMain {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertLast(2);
//        list.insertLast(3);
//        list.insertLast(5);
//        list.insertLast(6);
//        list.insertLast(7);
//        list.insertAtNth(8, 4);
//        list.display();
//        list.recursiveInsert(4,2);
//        list.display();

        //RemoveDuplicates
//        LL list2 = new LL();
//        list2.insertLast(1);
//        list2.insertLast(1);
//        list2.insertLast(1);
//        list2.insertLast(2);
//        list2.insertLast(2);
//        list2.insertLast(3);
//        list2.insertLast(3);
//        list2.display();
//        list2.removeDuplicates();
//        list2.display();

        //Merge two LLs
//        LL list1 = new LL();
//        list1.insertLast(1);
//        list1.insertLast(2);
//        list1.insertLast(4);
//        list1.display();
//        LL list2 = new LL();
//        list2.insertLast(1);
//        list2.insertLast(3);
//        list2.insertLast(4);
//        list2.display();

        //reverseRecursion
        LL list = new LL();
        list.insertLast(5);
        list.insertLast(4);
        list.insertLast(3);
        list.insertLast(2);
        list.insertLast(1);
        //list.reverseRecursion(list.getHead());
        list.reverseLL(list.getHead());
        list.display();

        }

    }

