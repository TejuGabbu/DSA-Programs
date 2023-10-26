import java.io.*;
import java.util.*;

class Main{
    static boolean solve(int a[],int n)
	{
		int temp[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				temp[i] = a[i];
			}
		Arrays.sort(temp); // sorted array

		// check and store first and last index;
		int first = -1;
		int last  = -1;
		int flag = 0;
		for(int i = 0 ; i<n ; i++)
			{
				if(a[i]!=temp[i] && flag == 0)
				{
					first = i;
					flag = 1;
				}
				if(a[i]!=temp[i] && flag == 1)
				{
					last = i;
				}
			}

		int l = last;
		for(int i = first ; i<=last ; i++)
			{
				if(a[i]!=temp[l]) return false;
				l--;
			}
		return true;
		
    }
	
    public static void main(String args[])throws IOException{    
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int arr[]=new int[N];

        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        boolean ans=solve(arr,N);
        
        if(ans==true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
