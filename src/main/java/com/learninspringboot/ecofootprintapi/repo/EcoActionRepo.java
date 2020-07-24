package com.learninspringboot.ecofootprintapi.repo;

import com.learninspringboot.ecofootprintapi.model.EcoAction;
import com.learninspringboot.ecofootprintapi.model.EcoFootprint;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EcoActionRepo extends MongoRepository<EcoAction, String> {

}
