package com.learncamel.test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import com.learncamel.route.CSVFileCreatorRoute;

public class CSVFilesRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception{
        return new CSVFileCreatorRoute();
    }

    @Test
    public void checkIfCsvIsCreatedProperly() throws InterruptedException, IOException {
    	String test = "1,Sebastiaan,NetherLands\n" + 
    			"2,Harshita,India\n" + 
    			"3,Prasita,India\n" + 
    			"4,JK,India\n" + 
    			"5,Geetha,India\n" + 
    			"6,New Name 6,New Country 6\n" + 
    			"7,New Name 7,New Country 7\n" + 
    			"8,New Name 8,New Country 8\n" + 
    			"9,New Name 9,New Country 9\n" + 
    			"10,New Name 10,New Country 10\n";
        Thread.sleep(5000);
        String  file = "data/output_2/file2.csv";
        StringBuilder contentBuilder = new StringBuilder();
        
        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) 
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        assertEquals(test , contentBuilder.toString());

    }
}

