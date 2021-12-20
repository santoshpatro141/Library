package com.example.library.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.library.model.Subscription;
import com.example.library.service.SubscriptionService;

@RestController("/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subSerice;

	public SubscriptionService getSubSerice() {
		return subSerice;
	}

	public void setSubSerice(SubscriptionService subSerice) {
		this.subSerice = subSerice;
	}
	
	@GetMapping
	public List<Subscription> getAll(){
		return subSerice.getAll();
	}
	
	@GetMapping("/{subcriberName}")
	public List<Subscription> findBySubcriberName(@PathVariable String subcriberName){
		return subSerice.findBySubcriberName(subcriberName);
		
	}
	
	@GetMapping
	public List<Subscription> getAll(@RequestParam String subcriberName ){
		return subSerice.getAll();
	}
	
	@GetMapping("/subscriptions/{subcriberName}/{bookId}")
	public Subscription findBySubcriberName(@PathVariable String subcriberName, @PathVariable String bookId){
//		return subSerice.findBySubcriberName(subcriberName);
		return subSerice.findBySubcriberNameAndBookId(subcriberName, Integer.parseInt(bookId));
	}
	
	@PostMapping
	public void createEmployee(@RequestBody @Valid Subscription subscription) throws Exception {

		subSerice.addSubscrition(subscription);

		// Getting current resource path
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(subscription.getSubscriptionId())
				.toUri();
	}
	

	
}
