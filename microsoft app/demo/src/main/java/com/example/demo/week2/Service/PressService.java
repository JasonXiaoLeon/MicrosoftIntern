package com.example.demo.week2.Service;
import com.example.demo.week2.Press;
import java.util.List;
import java.util.Optional;

public interface PressService {
    List<Press> findAll();
    Press save(Press press);
    Optional<Press> findById(int newsId);
    Optional<Press> findPressByIdFromDatabase(int newsId);
}
