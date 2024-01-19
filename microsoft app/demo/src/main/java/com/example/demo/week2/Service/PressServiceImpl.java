package com.example.demo.week2.Service;

import com.example.demo.week2.Press;
import com.example.demo.week2.Repository.PressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PressServiceImpl implements PressService{
    @Autowired
    private PressRepository pressRepository;
    private final List<Press> pressList = new ArrayList<>();
    @Override
    public List<Press> findAll() {
        ArrayList<Press> pressList=new ArrayList<Press>();
        pressList.add(new Press(1, "News Title 1", "https://example.com/cover1.jpg", "2024-01-19 08:00:00", "Author A",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                1500, 100, 50, true));

        pressList.add(new Press(2, "News Title 2", "https://example.com/cover2.jpg", "2024-01-19 09:30:00", "Author B",
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                2000, 120, 60, false));

        pressList.add(new Press(3, "News Title 3", "https://example.com/cover3.jpg", "2024-01-19 11:15:00", "Author C",
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.",
                1800, 80, 40, true));
        return pressList;
    }

    @Override
    public Press save(Press press) {
        // 在实际应用中，你可能需要将 Press 对象保存到数据库中
        pressList.add(press);
        return press;
    }

    @Override
    public Optional<Press> findById(int newsId) {
        return pressList.stream()
                .filter(press -> press.getNewsId() == newsId)
                .findFirst();

    }

    public Optional<Press> findPressByIdFromDatabase(int newsId) {
        return pressRepository.findByNewsId(newsId);
    }
}
