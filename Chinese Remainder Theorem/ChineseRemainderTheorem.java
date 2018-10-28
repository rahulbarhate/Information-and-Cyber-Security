import java.util.Scanner;
public class ChineseRemainderTheorem
{
	int n, M_val=1, x;
	int[] a = new int[10];
	int[] m = new int[10]; 
	int[] M = new int[10]; 
	int[] M_i = new int[10]; 
	Scanner sc = new Scanner(System.in);
	void acceptValues()
	{
		System.out.println("Enter the number of equations: ");
		n = sc.nextInt();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter a"+(i+1)+" :");
			a[i] = sc.nextInt();
			System.out.println("Enter m"+(i+1)+" :");
			m[i] = sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			M_val *= m[i]; 
		}
		for(int i=0;i<n;i++)
		{
			M[i] = M_val/m[i];
		}
	}
	
	void calculate()
	{
		for(int i=0;i<n;i++)
		{
			M_i[i] = (int) ((Math.pow(M[i], (m[i]-2))) % m[i]);
		}
		x=0;
		for(int i=0;i<n;i++)
		{
			x += (a[i]*M[i]*M_i[i]);
		}
		x = x % M_val; 
	}
	
	void print()
	{
		System.out.println("M_val = "+ M_val);
		for(int i=0;i<n;i++)
		{
			System.out.println("M"+(i+1)+" = " + M[i]);
		}	
		for(int i=0;i<n;i++)
		{
			System.out.println("Mi"+(i+1)+" = " + M_i[i]);
		}	
		System.out.println("-----X = "+x+"-----");
	}
	public static void main(String[] args)
	{
		ChineseRemainderTheorem obj = new ChineseRemainderTheorem();
		obj.acceptValues();
		obj.calculate();
		obj.print();
	}
}