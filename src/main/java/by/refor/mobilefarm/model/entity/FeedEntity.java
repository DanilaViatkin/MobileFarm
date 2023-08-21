package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "feeds")
@Data
public class FeedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedId;

    @OneToMany(mappedBy = "feed")
    private List<RationFeeds> rationFeeds;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Override
    public String toString(){
        return  "feedId = " + feedId + ", " +
                "type = " + type + ", " +
                "name = " + name;
    }
}
