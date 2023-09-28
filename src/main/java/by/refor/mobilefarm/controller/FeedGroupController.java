package by.refor.mobilefarm.controller;

import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.service.FeedGroupService;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/feedgroups")
public class FeedGroupController {
    private final FeedGroupService feedGroupService;

    @Autowired
    public FeedGroupController(FeedGroupService feedGroupService){
        this.feedGroupService = feedGroupService;
    }

    @GetMapping(value = "/{feedGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public FeedGroup getFeedGroupById(@PathVariable Long feedGroupId){
        return feedGroupService.getFeedGroupById(feedGroupId);
    }

    @GetMapping(value = "/byparams")
    @ResponseStatus(HttpStatus.OK)
    public List<FeedGroup> getFeedGroupByParams(@PathParam("type") @Nullable String type,
                                          @PathParam("age") @Nullable Integer age,
                                          @PathParam("productivity") @Nullable BigDecimal productivity,
                                          @PathParam("weight") @Nullable BigDecimal weight,
                                          @PathParam("geneticWeight") @Nullable BigDecimal geneticWeight){
        return feedGroupService.getFeedGroupByParams(type, age, productivity, weight, geneticWeight);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FeedGroup> getAllFeedGroups(){
        return feedGroupService.getAllFeedGroups();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FeedGroup createFeedGroup(@RequestBody FeedGroup feedGroup){
        return feedGroupService.createFeedGroup(feedGroup);
    }

    @PatchMapping(value = "/{feedGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public FeedGroup updateFeedGroupById(@RequestBody FeedGroup feedGroup,
                                            @PathVariable Long feedGroupId){
        return feedGroupService.updateFeedGroupById(feedGroupId, feedGroup);
    }

    @DeleteMapping("/{feedGroupId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteFeedGroupById(@PathVariable Long feedGroupId){
        feedGroupService.deleteFeedGroupById(feedGroupId);
    }
}
