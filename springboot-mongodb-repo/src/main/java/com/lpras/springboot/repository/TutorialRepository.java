package com.lpras.springboot.repository;

import com.lpras.lombok.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, Integer> {
    List<Tutorial> findByTitleContaining(String title);

    List<Tutorial> findByPublished(boolean published);
}
