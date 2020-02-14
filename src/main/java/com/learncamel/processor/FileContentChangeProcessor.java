/*
 * A simple camel processor to add additional lines to the output file
 * 
 */

package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FileContentChangeProcessor implements Processor {

	public void process(Exchange exchange) throws Exception {
			String body  = (String) exchange.getIn().getBody();
			StringBuilder str = new StringBuilder(body);
			str.append("This is Sebastiaan learing Camel");
			exchange.getIn().setBody(str.toString());
	}

}
