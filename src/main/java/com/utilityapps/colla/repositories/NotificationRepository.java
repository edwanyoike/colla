package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,Long> {
    List<Notification> findAllByCreatedBy_Id(Long id);

    List<Notification> findAllByCreatedBy_IdAndSeenIsTrue(Long ownerId);
    List<Notification> findAllByCreatedBy_IdAndSeenIsFalse(Long ownerId);

}
