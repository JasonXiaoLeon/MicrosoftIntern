package com.example.demo.week2.Controller;
import com.example.demo.week2.Press;
import com.example.demo.week2.Service.PressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PressController {
    @Autowired
    private PressService pressService;

    @GetMapping(value = "/Press")
    public List<Press> getPress(){
        return pressService.findAll();
    }

    // 新增方法：通过数据库查询任意 newsId 的 Press 对象
    @GetMapping("/press/{id}")
    public ResponseEntity<Press> getPressByIdFromDatabase(@PathVariable int id) {
        Optional<Press> press = pressService.findPressByIdFromDatabase(id);
        return press.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // 创建 Press 的 REST 接口
    @PostMapping("/press")
    public Press createPress(@RequestParam("newsId") int newsId,
                             @RequestParam("title") String title,
                             @RequestParam("coverImageUrl") String coverImageUrl,
                             @RequestParam("releaseDatetime") String releaseDatetime,
                             @RequestParam("author") String author,
                             @RequestParam("newsText") String newsText,
                             @RequestParam("viewsCount") int viewsCount,
                             @RequestParam("favoritesCount") int favoritesCount,
                             @RequestParam("sharesCount") int sharesCount,
                             @RequestParam("paidPromotionFlag") boolean paidPromotionFlag) {
        // 在实际应用中，你可能需要进行一些校验或其他操作
        // 例如，调用 pressService.save(press) 将 Press 对象保存到数据库中

        // 注意：这里将空格替换为 %20
        releaseDatetime = releaseDatetime.replace(" ", "%20");
        Press press = new Press(newsId, title, coverImageUrl, releaseDatetime, author, newsText,
                viewsCount, favoritesCount, sharesCount, paidPromotionFlag);
        return pressService.save(press);    }
}
