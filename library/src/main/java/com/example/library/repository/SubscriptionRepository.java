package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.library.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    @Query("SELECT t FROM Subscription t where t.subscriberName = :subscriberName") 
    List<Subscription> findSubscriptionByName(@Param("subscriberName") String subscriberName);
    
    List<Subscription> findBySubscriberName(String subscriberName);
    
    Optional<Subscription> findBySubscriberNameAndBookBookId(String subscriberName, Integer bookId);

}
