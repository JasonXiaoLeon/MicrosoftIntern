package com.microsoft.week4.demoProj.Service;

import com.microsoft.week4.demoProj.Entity.Press;
import com.microsoft.week4.demoProj.Mapper.PressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PressServiceImpl implements PressService {

    @Autowired
    private PressMapper pressMapper;


    @Override
    public List<Press> list() {
        return pressMapper.selectList(null);
    }

    @Override
    public Press getById(int newsId) {
        return pressMapper.selectById(newsId);
    }

    @Override
    public void save(Press press) {
        pressMapper.insert(press);
    }

    @Override
    public void updateById(Press press) {
        pressMapper.updateById(press);
    }
}
