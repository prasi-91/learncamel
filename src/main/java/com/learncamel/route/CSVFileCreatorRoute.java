/*
 * Camel routes to read a csv from a location and output to different location
 */

package com.learncamel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

import com.learncamel.model.CSVModel;
import com.learncamel.processor.CSVConverterProcessor;

public class CSVFileCreatorRoute extends RouteBuilder {
	final CSVConverterProcessor csvProcessor = new CSVConverterProcessor();
	final DataFormat bindy = new BindyCsvDataFormat(CSVModel.class);

	public void configure() throws Exception {
		
		from("file:data/inbox_2?fileName=file2.csv&noop=true").unmarshal(bindy).process(csvProcessor)
		.marshal(bindy).to("file:data/output_2?fileName=file2.csv&noop=true"); 

	}
}
