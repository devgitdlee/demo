package com.example.o2project.demo.Repository;

import com.example.o2project.demo.Enity.Artenity;

import org.springframework.data.repository.CrudRepository;

//객체 및 키값 설정
public interface ArtRepository extends CrudRepository<Artenity, Long> {

}
