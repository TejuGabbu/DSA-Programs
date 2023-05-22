import java.io.*;
import java.util.*;
 
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class LinkedList{
    Node head;
    void add(int data ){
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        Node current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution 
{
	 static Node merge(Node l1, Node l2)
	{
       Node dummy = new Node(-1);
		Node temp = dummy;
		while(l1!=null && l2!=null)
			{
				if(l1.data<l2.data)
				{
					temp.next = l1;
					temp = temp.next;
					l1 =l1.next;
				}
				else
				{
					temp.next = l2;
					temp = temp.next;
					l2 = l2.next;
				}
			}
		if(l1!=null)
		{
			temp.next = l1;
		}
		if(l2!=null)
		{
			temp.next = l2;
		}
		return dummy.next;
    }
}

public class MergeTwoSortedLinkedLists {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        LinkedList l2 = new LinkedList();
        for(int i=0;i<m;i++){
            l2.add(sc.nextInt());
        }

        Solution Ob = new Solution();
        Node head = Ob.merge(l1.head, l2.head);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}