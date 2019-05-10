package com.sample.repository;

import com.sample.model.PersonModel;
import org.fluentness.repository.Repository;

public class PersonRepository implements Repository {
    @Override
    public Class getModel() {
        return PersonModel.class;
    }
}
