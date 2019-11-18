package com.practice.elastic;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Builder
@Component
@Getter
@Setter
@Entity

@Document(indexName = "my_index", type = "user")
public class Person {

	@Id
	private Integer id;
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {return age;}
    public void setAge(int age) { this.age = age;}


//	public Person(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
//	public Person(){}
	
}
