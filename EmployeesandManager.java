import java.io.*;
import java.util.*;

class Solution 
{
	public static int findunder(HashMap<String , ArrayList<String>> company , String manager , TreeMap<String , Integer> fi) 
	{
		if(company.containsKey(manager)==false)
		{
			fi.put(manager,0);
			return 0;
		}
		int ct = 0;
		for(String emp : company.get(manager))
			{
				ct = ct + findunder(company,emp,fi) + 1;
			}
		fi.put(manager,ct);
		return ct;
	}
    public void EmpUnderManager(Map<String, String> emp)
	{
		HashMap<String , ArrayList<String>> company = new HashMap<>();
		String ceo = "";
		for(String remp: emp.keySet() )
			{
				String mng = emp.get(remp); //  2 row  c 
				
				if(mng.equals(remp)) //  if both emp and manager is same then it is ceo then we dont add it 
				{
					ceo = mng;
					continue;
				}

				
				if(company.containsKey(mng)==true)
				{
					ArrayList<String> nn = company.get(mng);
					nn.add(remp);
					company.put(mng,nn);
				}
				else
				{
					ArrayList<String> nn = new ArrayList<>();
					nn.add(remp);
					company.put(mng,nn);
				}
			}

		TreeMap<String , Integer> fi = new TreeMap<>();
		findunder(company , ceo ,fi);

		for(String key : fi.keySet())
			{
				System.out.println(key+" "+fi.get(key));
			}
		return;
		
	}
}

public class EmployeesandManager 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String,String> emp = new HashMap<String, String>();
        for(int i=0;i<n;++i){
			emp.put(sc.next(),sc.next());
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp); 
    }
}