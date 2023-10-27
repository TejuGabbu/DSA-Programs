import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public Node solve(Node head) 
	{
        // Write your code here
		Node temp = head;
		LinkedHashMap<Integer , Integer> map = new LinkedHashMap<>();
		while(temp!=null)
			{
				map.put(temp.data , map.getOrDefault(temp.data , 0)+1);
				temp = temp.next;
			}

		Node nn = new Node(-1);
		Node tej = nn;
		for(Integer ele : map.keySet())
			{
				if(map.get(ele)==1)
				{
					Node n = new Node(ele);
					tej.next = n;
					tej = tej.next;
				}
			}
		return nn.next;
    }
}

class Main {
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
