package com.utilityapps.colla.repositories;

import com.utilityapps.colla.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,Long> {
}
