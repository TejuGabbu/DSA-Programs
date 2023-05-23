import java.util.*;

class Solution 
{
	ArrayList<Integer> tej;

	public Solution()
	{
		tej = new ArrayList<>();	
	}
    public void add(int key) 
	{
        //Complete the function
		if(!tej.contains(key))
		{
	        tej.add(key);
		}
    }

    public void remove(int key) 
	{
        //Complete the function
		for(int i = 0; i<tej.size() ; i++)
			{
				if(tej.get(i)==key)
				{
					tej.remove(i);
				}
			}
    }

    public boolean contains(int key) 
	{
        //Complete the function
		for(int i=0;i<tej.size();i++)
		{
            if(tej.get(i)==key)
			{
	            return true;
			}
        }
        return false;
    }
}

public class DesignHashSet 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Solution Obj = new Solution();
        for (int i = 0; i < q; i++) {
            int choice = sc.nextInt();
            int key = sc.nextInt();
            if (choice == 1) {
                // Add
                Obj.add(key);
            } else if (choice == 2) {
                // contains
                if (Obj.contains(key)) {
                    System.out.print("True ");
                } else {
                    System.out.print("False ");
                }
            } else if (choice == 3) {
                // remove
                Obj.remove(key);
            }
        }
        System.out.println();
        sc.close();
    }
}