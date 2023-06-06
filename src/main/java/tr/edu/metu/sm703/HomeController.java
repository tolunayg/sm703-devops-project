package tr.edu.metu.sm703;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Get("/add/{num1}/{num2}")
    public Map<String, Object> addNumbers(@PathVariable int num1, @PathVariable int num2) {
        // Check if num1 or num2 are invalid
        if (num1 < 0 || num2 < 0) {
            throw new IllegalArgumentException("Invalid input: num1 and num2 must be non-negative integers.");
        }

        int sum = num1 + num2;
        Map<String, Object> response = new HashMap<>();
        response.put("num1", num1);
        response.put("num2", num2);
        response.put("sum", sum);
        return response;
    }
}
