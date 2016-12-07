package ie.cit.adf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.repositories.PledgeRepository;

@Service
public class PledgeService {
	
	@Autowired
	PledgeRepository pledgeRepository;

}
