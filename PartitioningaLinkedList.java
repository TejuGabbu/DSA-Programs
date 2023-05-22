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

class Solution {
    public void partition(Node head, int x) 
	{
        // Your code here
		Node temp = head;
		Node d1 = new Node(-1);
		Node t1 = d1;
		Node d2 = new Node(-1);
		Node t2 = d2;
		while(temp!=null)
			{
				if(temp.data<x)
				{
					t1.next = temp;
					t1 = t1.next;
				}
				else
				{
					t2.next = temp;
					t2 = t2.next;
				}
				temp = temp.next;
			}
		t1.next = null;
		t2.next = null;
		t1.next = d2.next;
		Node curr = d1.next;
		while(curr!=null)
			{
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
		return;
    }
}

public class PartitioningaLinkedList {
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList l1= new LinkedList();
        for(int i=0;i<n;i++){
            l1.add(sc.nextInt());
        }
        int x = sc.nextInt();
        Solution Ob = new Solution();
        Ob.partition(l1.head, x);
    }
}