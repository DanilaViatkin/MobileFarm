package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "rations")
@Data
public class RationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "feed_group_id", nullable = false)
    private FeedGroupEntity feedGroup;

    @OneToMany(mappedBy = "ration")
    private List<RationFeeds> rationFeeds;

    @Override
    public String toString(){
        return  "rationId = " + rationId + ", " +
                "geneticGroup = " + feedGroup + ", " +
                "rationFeeds = " + rationFeeds;
    }
}
