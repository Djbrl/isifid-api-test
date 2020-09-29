package isifid.techtestdsy;

public class EndpointResponse {
    //methods
	public static long fibonacci(long n) //recursive implementation of fibonacci
    {
		if (n < 2)
			return(n);
		return( fibonacci(n-2) + fibonacci(n-1) );
    }
	
	public static long factorial(long n) //recursive implementation of factorial
	{
	      if (n <= 1)
	          return 1;
	      return n * factorial(n - 1);
	}
}
