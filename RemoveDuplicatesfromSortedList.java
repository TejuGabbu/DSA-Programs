import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class RemoveDuplicatesfromSortedList {
    static Node head;
    static Node temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            head = null;
            temp = null;
            addToTheLast(a1);

            for (int i = 1; i < n; i++) {
                int data = sc.nextInt();
                addToTheLast(data);
            }
            Solution ans = new Solution();
            Node node = ans.solve(head);
            printList(node);
            System.out.println();
            sc.close();
    }

    public static void addToTheLast(int data) {
        if (head == null) {
            head = new Node(data);
            temp = head;
            return;
        } else {
            Node new_node = new Node(data);
            temp.next = new_node;
            temp = temp.next;
            return;
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Solution 
{
    public Node solve(Node head) 
	{
        // your code here
		Node dummy = new Node(-1);
		Node t = dummy;
		Node curr = head;
		while(curr!=null)
			{
				if(curr.next!=null && curr.data==curr.next.data)
				{
					Node a = curr;
					while(a!=null && curr.data==a.data)
						{
							a = a.next;
						}
					t.next = curr;
					t = t.next;
					curr = a;
				}
				else
				{
					t.next = curr;
					t = t.next;
					curr = curr.next;
				}
			}
		t.next = null;
		Node tej = dummy.next;
		return tej;
    }
}
