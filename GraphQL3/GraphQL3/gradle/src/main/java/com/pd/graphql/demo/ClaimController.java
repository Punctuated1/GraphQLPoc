package com.pd.graphql.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.benchmark.mongodb.Person;
import com.pd.graphql.jpa.SecurityControl;
import com.pd.graphql.jpa.SecurityControlDao;
import com.pd.graphql.jpa.SecurityControlRepository;


@Controller
public class ClaimController {
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private SecurityControlRepository securityControlRepository;
	
	@QueryMapping
	public Claim claimById(@Argument String id) {
		RestTemplate restTemplate = new RestTemplate();
		String claimUrl = "https://hmtawsbucket.s3.us-east-2.amazonaws.com/claims/claim."+id+".txt";
		ResponseEntity<String> response
		  = restTemplate.getForEntity(claimUrl, String.class);
		String responseString = response.getBody();
		System.out.println(responseString);
		Claim claim = null;
		try {
			claim = mapper.readValue(responseString, Claim.class);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return claim;
	}

    @SchemaMapping
    public Person person(Claim claim) {
    	long personId = claim.getPersonId(); 
    	System.out.println(personId);
    	Optional<Person> personOptional = personRepository.findById(personId);
    	Person person = personOptional.get();
        return person;
    }

    @SchemaMapping
    public List<SecurityControlDao> securityControls(Claim claim) {
    	long personId = claim.getPersonId(); 
    	System.out.println(personId);
    	Optional<Person> personOptional = personRepository.findById(personId);
    	Person person = personOptional.get();
    	List<SecurityControl> securityControls = securityControlRepository.findByCag(person.getCag());
    	
        return populateSecurityControlDaoList(securityControls);
    }

    @SchemaMapping
    public SecurityControlDao securityControlsCount(Claim claim) {
    	long personId = claim.getPersonId(); 
    	System.out.println(personId);
    	Optional<Person> personOptional = personRepository.findById(personId);
    	Person person = personOptional.get();
    	List<SecurityControl> securityControls = securityControlRepository.findByCag(person.getCag());
    	SecurityControlDao securityControlDao = new SecurityControlDao();
    	securityControlDao.setSecurityControlCount(securityControls.size());
        return securityControlDao;
    }

    private List<SecurityControlDao> populateSecurityControlDaoList(List<SecurityControl> securityControls){
    	List<SecurityControlDao> securityControlDaos = new ArrayList<SecurityControlDao>();
    	Iterator<SecurityControl> iterator = securityControls.iterator();
    	while(iterator.hasNext()) {
    		SecurityControlDao securityControlDao = new SecurityControlDao();
    		securityControlDaos.add(securityControlDao);
    		SecurityControl securityControl = iterator.next();
    		securityControlDao.setId("1.1 or more");
    		securityControlDao.setAccountId(securityControl.getId().getAccountId());
    		securityControlDao.setCag(securityControl.getCag());
    		securityControlDao.setClientCag(securityControl.getClientCag());
    		securityControlDao.setCarrierId(securityControl.getId().getCarrierId());
    		securityControlDao.setClientId(securityControl.getId().getClientId());
    		securityControlDao.setGroupId(securityControl.getId().getGroupId());
    		securityControlDao.setLineOfBusiness(securityControl.getLineOfBusiness());
    		securityControlDao.setPlanCode(securityControl.getId().getPlanCode());
    		securityControlDao.setSecurityRole(securityControl.getSecurityRole());
    		securityControlDao.setSecurityScope(securityControl.getSecurityScope());
    	}
    	
    	return securityControlDaos;
    }

}
