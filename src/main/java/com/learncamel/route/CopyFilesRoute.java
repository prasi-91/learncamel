/*
 * Camel routes to read a file from a location and output to different location
 */

package com.learncamel.route;

import org.apache.camel.builder.RouteBuilder;

import com.learncamel.processor.FileContentChangeProcessor;

public class CopyFilesRoute extends RouteBuilder {
	final FileContentChangeProcessor fileContentProcessor = new FileContentChangeProcessor();

	public void configure() throws Exception {
		String fileOptions = "?noop=true"; // https://camel.apache.org/components/latest/file-component.html
		String logOptions = "?level=INFO&showBody=true&showHeaders=true"; // https://camel.apache.org/components/latest/log-component.html
		from("file:data/inbox_1" + fileOptions).convertBodyTo(String.class).process(fileContentProcessor)
				.to("log:" + logOptions) 
				.to("file:data/output_1"); 


	}
}
