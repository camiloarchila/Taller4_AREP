package eci.arep;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RunTest {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.getInstance();
        String directory = "src/main/java/eci/arep";
        File directorypath = new File(directory);
        File fileList[] = directorypath.listFiles();
        ArrayList<Class<?>> classes = new ArrayList<>();
        for (File file : fileList) {
            String Name = file.toString().replace("\\", ".").substring(14).replace(".java", "");
            if (Class.forName(Name).isAnnotationPresent(Component.class)) {
                classes.add(Class.forName(Name));
            }
        }
        server.main(classes);
    }
}