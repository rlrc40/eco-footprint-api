package com.learninspringboot.ecofootprintapi.repo;

import com.learninspringboot.ecofootprintapi.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepo extends MongoRepository<Photo, String> {

}
