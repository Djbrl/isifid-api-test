package isifid.techtestdsy;

import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorHandling implements ErrorController //we're using the ErrorController interface implement our own ErrorHandling class
{
	//methods
	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request)
	{
		Integer status = 0;
		Exception exception = new Exception();
		//we pull the status and exception of the error into our variables
		//cast into int/exception-object to make sure we're receiving the correct type
		status = (Integer) request.getAttribute("javax.servlet.error.status_code"); 
		exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		//and return what we received
		return ("Oops ! Looks like an error occured. Status : " + status + ", Exception : " + exception);
	}

	//we use our custom error function over the default /error page
	@Override
	public String getErrorPath()
	{
		return "/error";
	}
}
