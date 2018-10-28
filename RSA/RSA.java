import java.math.BigInteger;
import java.util.Scanner;


public class RSA {

public static void main(String[] args)
{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter the value of p: ");
	int p=in.nextInt();
	System.out.println("Enter the value of q: ");
	int q=in.nextInt();
	System.out.println("Enter the value of M: ");
	String M=in.next();
	int phi=(p-1)*(q-1);
	int i=1;
	int d;
	int e=1;
	
	int j=2;
	
	while(j<phi)
	{
		if(phi%j==0)
		{
			j++;
		}
		else
		{
			e=j;
			break;		
		}
	}
	
	if(((phi*i)+1)%e ==0)
	{
		d=((phi*i)+1)/e;
	}
	else
	{
		i=i+1;
		while(true)
		{
			if((((phi*i) + 1) % e)==0)
			{
				d=((phi*i)+1)/e;
				break;
			}
			else
			{
				i=i+1;
			}
		}
	}
	System.out.println("value of e is:" +e);
	System.out.println("value of phi is:" +phi);
	System.out.println("value of d is:" +d);
	
	System.out.println("value of public key is:{"+e+","+(p*q)+"}");
	System.out.println("value of private key is:{"+d+","+(p*q)+"}");
	BigInteger b1,b2,b3,b4;
	b1=new BigInteger(M);
	b2= BigInteger.valueOf(p*q);
	b3=b1.pow(e);
	b3= b3.mod(b2);
	b4=b3.pow(d);
	b4=b4.mod(b2);
	
	System.out.println("value of C is:"+b3);
	System.out.println("value of M is:"+b4);


}


}