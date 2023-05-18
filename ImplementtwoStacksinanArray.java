import java.util.*;

class twoStacks 
{
	int[] a;
	int size;
	int top1, top2;

	// Constructor
	twoStacks(int n)
	{
		size = n;
		a = new int[n];
		top1 = -1;
		top2 = n;
	}

	// Method to push an element x to stack1
	void push1(int x)
	{
         // Your code here
		if(top1+1==top2)
		{
			return;
		}
		top1 = top1+1;
		a[top1] = x;
		return;
	}

	// Method to push an element
	// x to stack2
	void push2(int x)
	{
       // Your code here
		if(top2-1==top1)
		{
			return; 
		}
		top2 = top2-1;
		a[top2] = x;
		return;
	}

	// Method to pop an element from first stack
	void pop1()
	{
		// Your code here
		if(top1==-1)
		{
			System.out.println(-1);
			return;
		}
		int topValue = a[top1];
		a[top1] = -1;
		top1--;
		System.out.println(topValue);
	}

	// Method to pop an element
	// from second stack
	void pop2()
	{
		// Your code here
		if (top2 == size) 
		{
			System.out.println(-1);
			return;
		} 
		int topValue = a[top2];
		a[top2] = -1;
		top2++;
		System.out.println(topValue);
	}
};
public class ImplementtwoStacksinanArray 
{

	/* Driver program to test twoStacks class */
	public static void main(String[] args)
	{
		twoStacks ts = new twoStacks(50);
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        for(int i =0; i<n; i++){
            int temp;
            temp = sc.nextInt();
            if(temp == 1) ts.pop1();
            else if(temp==3) ts.pop2();
            else if(temp == 2) {
                int temp2;
                temp2 = sc.nextInt();
                ts.push1(temp2);
            }
            else{
                int temp2;
                temp2 = sc.nextInt();
                ts.push2(temp2);
            }
        }
	}
}