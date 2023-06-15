package tr.edu.metu.sm703;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private String password = "myPassword123"; // Vulnerability: Storing password in plain text

    @Get("/add/{num1}/{num2}")
    public Map<String, Object> addNumbers(@PathVariable int num1, @PathVariable int num2) {
        // Perform the addition operation
        int sum = num1 + num2;
        Map<String, Object> response = new HashMap<>();
        response.put("num1", num1);
        response.put("num2", num2);
        response.put("sum", sum);

        // TODO: Todo example to be detected by codeQL
        return response;
    }

    @Get("/users/{id}")
    public Map<String, Object> getUserById(@PathVariable String id) {
        // Insecure user authentication
        boolean authenticated = authenticateUser(id, password); // Vulnerability: Insecure authentication

        if (authenticated) {
            // Fetch and return user data
            Map<String, Object> userData = fetchUserData(id);
            return userData;
        } else {
            // Return an error message if authentication fails
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Authentication failed");
            return errorResponse;
        }
    }

    private boolean authenticateUser(String id, String password) {
        // Insecure authentication logic
        // In this example, authentication is based on a fixed password without encryption or validation
        return password.equals("myPassword123"); // Vulnerability: Insecure password comparison
    }

    private Map<String, Object> fetchUserData(String id) {
        // Simulated method to fetch user data from a database
        // This method is not implemented for simplicity
        // ...
        // Potential vulnerability: The 'id' parameter is not validated or sanitized before using it in the query
        // ...
        return new HashMap<>();
    }
}
