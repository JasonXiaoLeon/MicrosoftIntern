package com.example.demo.week2.Repository;

import com.example.demo.week2.Press;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PressRepository extends CrudRepository<Press, Integer> {
    Optional<Press> findByNewsId(int newsId);
}