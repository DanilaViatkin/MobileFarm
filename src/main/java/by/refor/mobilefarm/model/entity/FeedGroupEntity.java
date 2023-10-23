package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "feed_groups")
@Data
@Accessors(chain = true)

public class FeedGroupEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_group_id")
    private Long feedGroupId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "lactation_from")
    private Integer lactationFrom;

    @Column(name = "lactation_to")
    private Integer lactationTo;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "genetic_weight")
    private BigDecimal geneticWeight;

    @Column(name = "productivity")
    private BigDecimal productivity;

    @Column(name = "genetic_productivity")
    private BigDecimal geneticProductivity;

    @Column(name = "age_from")
    private Integer ageFrom;

    @Column(name = "age_to")
    private Integer ageTo;

    @Column(name = "name")
    private String name;

    @Column(name = "average_daily_gain")
    private Integer averageDailyGain;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrients_rate_id")
    private NutrientsEntity nutrients;

    @OneToMany(mappedBy = "feedGroup", fetch = FetchType.EAGER)
    private List<RationEntity> rations;

    @OneToMany(mappedBy = "feedGroup", fetch = FetchType.EAGER)
    private List<AnimalPassportEntity> animalPassports;

    @Override
    public String toString(){
        return  "feedGroupId = " + feedGroupId + ", " +
                "type = " + type + ", " +
                "productivity = " + productivity + ", " +
                "geneticProductivity = " + geneticProductivity + ", " +
                "weight = " + weight + ", " +
                "geneticWeight = " + geneticWeight + ", " +
                "ageFrom = " + ageFrom + ", " +
                "ageTo = " + ageTo + ", " +
                "lactationFrom = " + lactationFrom + ", " +
                "lactationTo = " + lactationTo + ", " +
                "averageDailyGain = " + averageDailyGain + ", " +
                "rations = " + (Objects.isNull(rations) ? 0 : rations.size());
    }
}
