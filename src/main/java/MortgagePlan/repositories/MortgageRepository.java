package MortgagePlan.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface MortgageRepository extends MongoRepository<MortgagePlan.app.models.Mortgage, String> {
    public MortgagePlan.app.models.Mortgage findById(ObjectId _id);
}