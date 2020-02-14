package com.learncamel.main.app;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.impl.DefaultCamelContext;

import com.learncamel.model.Employee;
import com.learncamel.route.CSVFileCreatorRoute;
import com.learncamel.route.CopyFilesRoute;

public class CamelMainApp {
	public static void main(String[] args) throws JAXBException {

		// In order for the whole Camel project to work, we need the Camel Context
		CamelContext context = new DefaultCamelContext(); // Now we have defined the context
		context.setUseMDCLogging(true);
		
		// Defining Jaxb and JSON Depedencies
		final JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Employee.class);
		xmlDataFormat.setContext(con);
		final JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
		

		// Next thing is to add routes - First Way Directly adding routes by creating routes there itself
		try {

			context.addRoutes(new RouteBuilder() {
				// This route reads an xml file and converts it to a json
				@Override
				public void configure() throws Exception {
					from("file:data/inbox_3?fileName=file1.xml&noop=true").unmarshal(xmlDataFormat).
					marshal(jsonDataFormat).
					to("file:data/output_3?fileName=file2.json&noop=true");  // Sending to a file
				}
			});
			
			
			// Second Way define the Routes in separate files
			context.addRoutes(new CopyFilesRoute());
			context.addRoutes(new CSVFileCreatorRoute());

			context.start(); // We start the context which automatically starts the route
			Thread.sleep(5000); // Without the delay, the route is unable to move something, that's why we are inserting the delay
			context.stop(); // After completing the route, we need to stop the route

		} catch (Exception e) {
			System.out.println("Exception is : " + e);
			e.printStackTrace();
		}
	}
}
