import java.security.* ;
import java.util.Scanner ;

public class SHA1
{
	public static String byte_hex(byte[] b)
	{ 
		// Initializing hex_digit[]
		char hex_digit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
							'8', '9', 'A', 'B', 'C', 'D', 'E', 'F'} ;

		// Creating a StringBuffer object
		StringBuffer buf = new StringBuffer() ;

		int j=0 ;
		for(j=0; j<b.length; j++)
		{
			buf.append(hex_digit[(b[j] >> 4) & 0x0f]) ;
			buf.append(hex_digit[(b[j]) & 0x0f]) ;
		}

		return buf.toString() ;
	}


	public static void main(String[] args)
	{
		try
		{
			// Message Digest object 
			MessageDigest md = MessageDigest.getInstance("SHA1") ;

			// Printing MessageDigest data
			System.out.println("MessageDigest Information: ") ;
			System.out.println("") ;
			System.out.println("Algorithm: " + md.getAlgorithm()) ;
			System.out.println("Provider:  " + md.getProvider()) ;
			System.out.println("toString:  " + md.toString()) ;
			System.out.println("") ;

			// Initialize Scanner
			Scanner sc = new Scanner(System.in) ;

			// Take and print input
			System.out.println("Enter the input: ") ;
			String input = sc.nextLine() ;
			System.out.println("Input is: " + input) ;
			System.out.println("") ;

			// update function of MessageDigest object
			md.update(input.getBytes()) ;

			// digest function which returns an array of bytes
			byte[] output = md.digest() ;

			// Print output 
			System.out.println("SHA1 for input is: ") ;
			System.out.println(" " + byte_hex(output)) ;
			System.out.println("") ;
		}

		catch(Exception e)
		{
			System.out.println("Exception: " + e) ;
			System.out.println("") ;
		}
	}
}