/*
 * A simple camel processor to add more rows to the csv and output it
 * 
 */

package com.learncamel.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.learncamel.model.CSVModel;

public class CSVConverterProcessor implements Processor {


    public void process(Exchange exchange) throws Exception {
        List<CSVModel> testList =(ArrayList<CSVModel>) exchange.getIn().getBody();
        Integer lastNum = testList.get((testList.size() -1)).getSINo();
        for(int i=0; i<=4; i++) {
        	CSVModel csvModel = new CSVModel();
        	lastNum++;
        	csvModel.setSINo(lastNum);
        	csvModel.setName("New Name " + lastNum);
        	csvModel.setCountry("New Country " + lastNum);
        	testList.add(csvModel);
        }
        exchange.getIn().setBody(testList);
    }

}
