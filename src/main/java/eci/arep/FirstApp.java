package eci.arep;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class FirstApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        HttpServer server = HttpServer.getInstance();
        server.run(args);
    }
}
