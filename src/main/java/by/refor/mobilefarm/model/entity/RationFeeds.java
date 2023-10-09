package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Entity
@Table(name = "ration_feeds")
@Data
@Accessors(chain = true)
public class RationFeeds {
    @EmbeddedId
    private RationFeedKey id;

    @ManyToOne
    @MapsId("rationId")
    @JoinColumn(name = "ration_id")
    private RationEntity ration;

    @ManyToOne
    @MapsId("feedId")
    @JoinColumn(name = "feed_id")
    private FeedEntity feed;

    @Column(name = "amount")
    private BigDecimal amount;

    @Override
    public String toString(){
        return  "feed = " + feed + ", " +
                "amount = " + amount;
    }
}
