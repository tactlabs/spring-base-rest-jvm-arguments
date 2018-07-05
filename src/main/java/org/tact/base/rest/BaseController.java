package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T testBase() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");

        return (T) map;
    }
    
    @Value("${environment}")
    private String environment;
    
    /**
     * 
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/jvm/argument
     */
    @RequestMapping(value = "/jvm/argument", method = RequestMethod.GET)
    public <T> T getJVMArguments() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("env", environment);        
        
        return (T) map;
    }
}
