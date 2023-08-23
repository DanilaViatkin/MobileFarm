package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.service.FeedService;
import by.refor.mobilefarm.service.impl.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/feeds")
public class FeedController {

    private final FeedService feedService;

    @Autowired
    public FeedController(FeedServiceImpl feedService){
        this.feedService = feedService;
    }

    @GetMapping
    public List<Feed> getAll(){
        return feedService.getAll();
    }

}
