package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.Notification;
import com.utilityapps.colla.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,Long> {
    List<Notification> findAllByOwnerId(Long id);

    List<Notification> findAllByOwnerIdAndSeenIsTrue(Long ownerId);
    List<Notification> findAllByOwnerIdAndSeenIsFalse(Long ownerId);

}
