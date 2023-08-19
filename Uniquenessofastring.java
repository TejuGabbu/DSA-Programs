import java.util.*; 

public class Uniquenessofastring {
    public static void main(String args[]) {
        
        Scanner scn = new Scanner(System.in); 
        int n = scn.nextInt(); 
        String st = scn.next(); 
        
        solution sol = new solution();
        int ans = sol.solve(st); 
        System.out.println(ans); 
    }
} 

 class Node {

  Node children[];
  boolean eow;

  Node() {
    children = new Node[26];
    for (int i = 0; i < children.length; i++) {
      children[i] = null;
    }
    eow = false;
  }
}   
class solution{
	
	 static Node root = new Node();

  public static void insert(String word) 
	{
    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      int ind = word.charAt(i) - 'a';
      if (curr.children[ind] == null) {
        curr.children[ind] = new Node();
      }
      if (i == word.length() - 1) curr.children[ind].eow = true;
      curr = curr.children[ind];
    }
  }

	public static int count(Node root)
	{
		if(root==null) return 0;
		int ct = 0;
		for(int i = 0 ; i<26 ; i++)
			{
				if(root.children[i]!=null)
				{
					ct+=count(root.children[i]);
				}
			}
		return ct+1;
	}
    public static int solve( String st)
	{
        for(int i = 0 ; i<st.length(); i++)
			{
				insert(st.substring(i)); 
			}
		return count(root);
    }  
}