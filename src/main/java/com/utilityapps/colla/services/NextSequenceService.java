package com.utilityapps.colla.services;

import com.utilityapps.colla.interfaces.NextSequenceServiceI;
import com.utilityapps.colla.models.CustomSequences;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class NextSequenceService implements NextSequenceServiceI {


     private final MongoOperations mongo;

    public NextSequenceService(MongoOperations mongo) {
        this.mongo = mongo;
    }

    @Override
    public Long getNextSequence(String seqName)
    {
        CustomSequences counter = mongo.findAndModify(
                query(where("_id").is(seqName)),
                new Update().inc("seq",1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);
        if (counter != null) {
            return counter.getSeq();
        }

        return 0L;
    }
}
