package com.truedash.security.saml.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate; 

//import com.jcg.example.bean.UserBean;

//rajnagulapalle/reddie002

// Sample Response

/**
*	{"id":58,"username":"testmv","tokenValue":"ng1ksr5ce9vqrhtevb56c075is660r1l","roles":["ROLE_USER"],"intercomHash"
*	:"856f2de216c71dca3dd150bede61f1f28ca52d47937b4ed16bca6e5b78b16cc3","fullName":"Test MV","dateCreated"
*	:1406851200000,"organisation":{"id":6,"name":"Monica Vinader","location":"London","logo":"https://truedash-static
*	.s3.amazonaws.com/images/sandbox/6/logo/organizationLogo"},"firstName":"Test","lastName":"MV","locale"
*	:"en","timezone":"GMT","photo":null,"mfaToken":"false","mfaTokenConfirmed":false}
**/

@Controller
@RequestMapping("/redirect")
public class RedirectController {
	
	private final Logger log = LoggerFactory.getLogger(RedirectController.class);
	
	@RequestMapping(value = "/truedash")
    public String generateMetadata(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		
		if(authentication == null){
			log.info("******No athentication object found****");
		} 
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "testmv");
		params.put("password", "nimda");
		params.put("orgName", "Org1");
		

		String url = "";
		url = "https://dev.truedash.com/truedash/user/samlLogin?username=testmv&password=nimda&orgName=Org1";
		//url = "http://localhost:8081/truedash/user/samlLogin?username=testmv&password=nimda&orgName=Org1";
		System.out.println(params);
		//HttpEntity entity = new HttpEntity(headers);
		
		/*UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("username", "testmv")
		        .queryParam("password", "nimda")
		        .queryParam("orgName", "Org1");*/

		//HttpEntity<java.lang.String> responseRest = restTemplate.exchange("https://dev.truedash.com/truedash/user/login", HttpMethod.POST, entity, String.class, params);
	    //http://localhost:8081/truedash/user/login
		//HttpEntity<java.lang.String> responseRest = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entity, String.class);
		
//		String redirectUrl = request.getScheme() + "https://dev.truedash.com/truedash/auth/login?username=testmv&password=nimda";
		//JSONObject jsonObj = new JSONObject(responseRest.getBody());
		//System.out.println(jsonObj.get("tokenValue"));
		//System.out.println(responseRest.getBody());
		//String redirectUrl = request.getScheme() + "://dev.truedash.com";
		//redirectUrl = builder.build().encode().toUri();
	    return "redirect:" + url;

    }
}