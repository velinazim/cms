package com.example.repository;

import com.example.entity.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {

    @Query("{\"bool\":{\"must\": [{\"match\": {\"name\":\"?0\"}}]}}")
    List<Person> getByCustomQuery(String search);

    List<Person> getByNameLikeOrLast_nameLike(String name, String last_name);
}
