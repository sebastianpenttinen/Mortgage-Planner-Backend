package MortagePlan.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import MortagePlan.app.models.Mortage;

public interface MortageRepository extends MongoRepository<Mortage, String> {
    public Mortage findById(ObjectId _id);
}