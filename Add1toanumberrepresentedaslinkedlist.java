import java.util.*;
import java.io.*;

class Node
	{
		int data;
		Node next;

		Node(int x)
		{
			this.data = x;
			this.next = null;
		}
	}


class Solution
{
        public static void add1(int x)
		{
            int num = x + 1;
			Node tej = new Node(-1);
			Node temp = tej;
			while(num!=0)
				{
					int p = num%10;
					Node nn = new Node(p);
					temp.next = nn;
					temp = temp.next;
					num = num/10;
				}
			Node head = rever(tej.next);
			Node s = head;
			while(s!=null)
				{
					System.out.print(s.data+" ");
					s = s.next;
				}
			return;
			
        }
	public static Node rever(Node head)
	{
		Node curr = head;
		Node prev = null;
		while(curr!=null)
			{
				Node t = curr.next;
				curr.next = prev;
				prev = curr;
				curr = t;
			}
		return prev;
	}
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         int x = sc.nextInt();
            Solution ob = new Solution();
            ob.add1(x);
    }
}