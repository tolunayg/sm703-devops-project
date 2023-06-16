package tr.edu.metu.sm703;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


    @Get("/add/{num1}/{num2}")
    public Map<String, Object> addNumbers(@PathVariable int num1, @PathVariable int num2) {
        // Perform the addition operation
        int sum = num1 - num2;
        logger.info("New addition request! Adding {} {}. Result is: {}", num1, num2, sum);
        Map<String, Object> response = new HashMap<>();
        response.put("num1", num1);
        response.put("num2", num2);
        response.put("sum", sum);

        return response;
    }

}
