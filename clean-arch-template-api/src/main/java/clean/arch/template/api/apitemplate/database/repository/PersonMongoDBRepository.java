package clean.arch.template.api.apitemplate.database.repository;

import clean.arch.template.api.apitemplate.database.presentation.PersonPresentation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMongoDBRepository extends MongoRepository<PersonPresentation, String> {}