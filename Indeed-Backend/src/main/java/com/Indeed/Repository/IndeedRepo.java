package com.Indeed.Repository;

import com.Indeed.Model.Indeed;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndeedRepo extends MongoRepository<Indeed, Long> {

  Optional<Indeed> findFirstByOrderByIdDesc();
}
