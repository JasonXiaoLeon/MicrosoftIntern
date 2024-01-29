package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.Press;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PressService {
    List<Press> list();
    Press getById(int newsId);
    void save(Press press);
    void updateById(Press press);
}
