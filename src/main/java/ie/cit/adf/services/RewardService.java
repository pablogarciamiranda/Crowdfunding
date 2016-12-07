package ie.cit.adf.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.repositories.RewardRepository;

@Service
public class RewardService {
	
	@Autowired
	RewardRepository rewardRepository;

}
