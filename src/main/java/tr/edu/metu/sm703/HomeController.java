package tr.edu.metu.sm703;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Get("/users/{id}")
    public Map<String, Object> getUserById(@PathVariable String id) {
        // Vulnerability: Directly concatenating user input into the SQL query
        String query = "SELECT * FROM users WHERE id = " + id;

        // Execute the query and return the user data
        Map<String, Object> userData = executeQuery(query);
        return userData;
    }

    private Map<String, Object> executeQuery(String query) {
        // Simulated method to execute the SQL query and fetch data
        // This method is not implemented for simplicity
        // ...
        // Vulnerability: SQL Injection can occur if 'id' parameter is not properly sanitized
        // ...
        return new HashMap<>();
    }
}
