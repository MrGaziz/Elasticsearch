package com.practice.elastic;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, Integer> {
  List<Person> findPersonByAge(Integer age);
  List<Person> findPersonByNameAndAge(String name,Integer age);
 }
