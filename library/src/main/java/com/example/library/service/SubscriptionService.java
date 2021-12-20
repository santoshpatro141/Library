package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.model.Subscription;
import com.example.library.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	private SubscriptionRepository subRepo;

	public SubscriptionRepository getSubRepo() {
		return subRepo;
	}

	public void setSubRepo(SubscriptionRepository subRepo) {
		this.subRepo = subRepo;
	}
	
	
	public List<Subscription> getAll(){
		return subRepo.findAll();
	}
	
	public void save(Subscription sub) {
		subRepo.save(sub);
	}
	
	public List<Subscription> findBySubcriberName(String subcriberName){
		return subRepo.findBySubscriberName(subcriberName);
	}
	
	public Subscription findBySubcriberNameAndBookId(String subcriberName, Integer bookdId){
		return subRepo.findBySubscriberNameAndBookBookId(subcriberName, bookdId).orElseThrow();
	}
	
	public Integer addSubscrition(Subscription subscription) {

		subRepo.save(subscription);
		return subscription.getSubscriptionId();
	}
}
