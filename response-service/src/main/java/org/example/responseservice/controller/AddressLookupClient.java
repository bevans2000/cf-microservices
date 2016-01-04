package org.example.responseservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.responseservice.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressLookupClient {

	// Name of the service to call upon. Name appears to becomes upper case in Eureka service
	private final static String CASE_SERVICE_NAME = "CASE-SERVICE";
	
	// URL of address endpoint
	private static final String CASE_ADDRESS_URL = "/api/cases/{qid}/address";

	private static Log LOG = LogFactory.getLog(AddressLookupClient.class);

	// Load balancer
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@Autowired
    private RestTemplate restTemplate;
	
	/**
     * Complement this with a simpler version without fallback-url!
     *
     * Taken from http://callistaenterprise.se/blogg/teknik/2015/04/10/building-microservices-with-spring-cloud-and-netflix-oss-part-1/
     * @param serviceId
     * @param fallbackUri
     * @return
     */
    private String getServiceUrl(String serviceId, String fallbackUri) {
        String url = null;
        try {
            ServiceInstance instance = loadBalancer.choose(serviceId);
            url = instance.getUri().toString();
            LOG.info("Resolved serviceId '" + serviceId + "' to URL '" + url + "'.");

        } catch (RuntimeException e) {
            // Eureka not available, use fallback
            url = fallbackUri;
            LOG.warn("Failed to resolve serviceId '" + serviceId + "'. Fallback to URL '" + url + "'.");
        }

        return url;
    }
    
    /**
     * Looks up the address for a questionnaire id
     * @param qid
     * @return
     */
	public String getAddress(int qid) {
		String address = "Default";
		
		// Enabled the Ribbon client so autowired RestTemplate becomes Ribbon aware
		//String serviceBase = getServiceUrl(CASE_SERVICE_NAME, "http://localhost:8082");
		String serviceBase = "http://" + CASE_SERVICE_NAME;
		
	    final String uri = serviceBase + CASE_ADDRESS_URL;
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("qid", Integer.toString(qid));
	    
	    LOG.info("Making a call to " + uri);
	    
	    Address result = restTemplate.getForObject(uri, Address.class, params);
		if (result != null) {
			address = getFullAddress(result);
		}
	    
		return address;
	}

	/**
	 * Should be a seperate method
	 * @param result
	 * @return
	 */
	private static String getFullAddress(Address result) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(result.getLine1());
		buffer.append(' ');
		buffer.append(result.getLine2());
		buffer.append(' ');
		buffer.append(result.getPosttown());
		buffer.append(' ');
		buffer.append(result.getPostcode());
		buffer.append(' ');
		
		return buffer.toString();
	}
}
