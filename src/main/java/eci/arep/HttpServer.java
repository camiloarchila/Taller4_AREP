package eci.arep;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.util.Objects;

/**
 * Clase principal que contiene el servidor web
 */
public class HttpServer {
    private static HttpServer instance = new HttpServer();
    public static HttpServer getInstance() {
        return instance;
    }

    private Map<String,Method> services = new HashMap<>();

 public void main(ArrayList<Class<?>> args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {

            for(Class clase: args) {
                Method[] methods = clase.getMethods();

                for (Method m : methods) {
                    System.out.println(m);
                    if (m.isAnnotationPresent(RequestMapping.class)) {
                        String path = m.getAnnotation(RequestMapping.class).value();
                        System.out.println("path" + path + " " + m.getName());
                        services.put(path, m);
                    }
                }
            }
//        }
        // extraeer el valor del path
        // extraer una instancia del metodo
        // poner en la tabla el metodo con llave path

         ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
             System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while(running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;
            String pelicula = "";
            String service = "";
            Boolean flag = true;
            outputLine = Gethtml();
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if(flag){
                    flag = false;
                }
                if (inputLine.contains("/apps/")) {
                    service = inputLine.split("/apps")[1].split("HTTP")[0].replaceAll(" ", "");
                    System.out.println(service + " " + services.get("/hello"));
                    outputLine = Gethtml() + services.get(service).invoke(null);
                }
                if (!in.ready()) {
                    break;
                }
            }
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    private String Gethtml(){
     return "HTTP/1.1 200 OK\r\n"
             + "Content-Type: text/html\r\n"
             + "\r\n"
             + "<h1>Prueba html</h1>";
    }
}
