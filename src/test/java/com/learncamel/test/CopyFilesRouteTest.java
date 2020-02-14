package com.learncamel.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.route.CopyFilesRoute;

public class CopyFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception{
        return new CopyFilesRoute();
    }

    @Test
    public void checkIfRouteWorked() throws InterruptedException, IOException {
        Thread.sleep(5000);
        String  file = "data/output_1/file1.txt";
        StringBuilder contentBuilder = new StringBuilder();
        
        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        assertEquals("Hi, this is file 1 :-)This is Sebastiaan learing Camel" + "\n", contentBuilder.toString());
    }
}

