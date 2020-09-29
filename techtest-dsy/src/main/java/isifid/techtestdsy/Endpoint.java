package isifid.techtestdsy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {
	//variables
	private String	welcome	= "Welcome ! Input your PathVariable as an integer in the URL to use the API. Example : [url:port]/[input]";
	private String	HTTP_400_Code = "BAD_REQUEST";
	private String	error = "Sorry I don't handle this input for PathVariable, please refer to the root page for the valid values.";
	
	//methods
	@GetMapping(path = {"/"})
	public String	homePage() {
		return(welcome);
	}

	@GetMapping(path = {"/{input}"})
	public String	getPathVariable(@PathVariable(name = "input") Integer input) {
		if(input < 0)
			return (HTTP_400_Code);
		else if (input % 2 != 0)
			return ("Fibonacci of " + input + " : " + EndpointResponse.fibonacci(input));
		else if ((input % 2 == 0 )&& input < 51)
		{
			if (input < 22)
				return ("Factorial of " + input + " : " + EndpointResponse.factorial(input));
			return("Oops ! Sorry, that factorial is too big for my data type. Here's the closest I can compute : " + EndpointResponse.factorial(20));
		}
		else if ((input % 2 == 0) && input > 50)
			return ("Your input : " + input);
		else
			return (error);
	}
}
