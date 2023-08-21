package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rations")
@Data
public class RationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genetic_group_id", nullable = false)
    private GeneticGroupEntity geneticGroup;

    @OneToMany(mappedBy = "ration")
    private List<RationFeeds> rationFeeds;

    @Override
    public String toString(){
        return  "rationId = " + rationId + ", " +
                "geneticGroup = " + geneticGroup + ", " +
                "rationFeeds = " + rationFeeds;
    }
}
