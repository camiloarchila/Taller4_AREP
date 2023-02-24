package eci.arep;

@Component()
public class HelloController {
    @RequestMapping("/hello")
    public static String index() {
        return "Greetings from Spring Boot!";
    }
}