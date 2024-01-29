package com.microsoft.week4.demoProj.Controller;

import com.microsoft.week4.demoProj.Entity.Press;
import com.microsoft.week4.demoProj.Service.PressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/press")
public class PressController {
    @Autowired
    private PressService pressService;

    @GetMapping("/list")
    public List<Press> getNewsList() {
        return pressService.list();
    }

    @GetMapping("/list/{newsId}")
    public Press getNewsById(@PathVariable int newsId) {
        return pressService.getById(newsId);
    }

    @PostMapping("/upload")
    public void uploadNews(@RequestBody Press press) {
        pressService.save(press);
    }

    @PutMapping("/update/{newsId}")
    public void updateNews(@PathVariable int newsId, @RequestBody Press press) {
        press.setNewsId(newsId); // 确保newsId被设置以进行更新
        pressService.updateById(press);
    }
}
