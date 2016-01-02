package org.example.responseservice.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.responseservice.model.Response;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responses")
public class ResponseRestController {
	private static Log logger = LogFactory.getLog(ResponseRestController.class);

	/**
	 * Identifies the parent survey identifier from a response. Does this by using the Qid.
	 * Ideally should be in a seperate class away from Controller.
	 * @param newResponse
	 * @return
	 */
	private final static String getSurvey(Response newResponse) {
		String surveyId = "Survey" + newResponse.getQid() % 2;
		
		return surveyId;
	}
	
	/**
	 * Signifies the receipt of a response
	 * @param response
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public Response create(@RequestBody Response response) {
		logger.info("Received " + response);
		
		// TODO: Contact Case service to receive address information
		
		// TODO: Attach address info to the response
		
		String surveyChannel = "Outbound-" + getSurvey(response);
		
		// TODO: Forward to Redis queue according to the Survey
		return response;
	}
}
