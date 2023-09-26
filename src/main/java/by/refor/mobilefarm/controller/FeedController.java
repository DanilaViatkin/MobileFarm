package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.entity.NutrientsEntity;
import by.refor.mobilefarm.service.FeedService;
import by.refor.mobilefarm.service.impl.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Feed createFeed(@RequestBody Feed feed){
        return feedService.createFeed(feed);
    }

    @DeleteMapping("/{feedId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFeedById(@PathVariable Long feedId){
        feedService.deleteFeedById(feedId);
    }
}
