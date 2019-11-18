package com.practice.elastic;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Builder
@Data
@Getter
@Setter
@Document(indexName = "my_index", type = "user")
@AllArgsConstructor
@NoArgsConstructor
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
