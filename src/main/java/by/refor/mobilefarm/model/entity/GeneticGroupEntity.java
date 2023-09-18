package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "genetic_groups")
@Data
@Accessors(chain = true)
public class GeneticGroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genetic_group_id")
    private Long geneticGroupId;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "productivity")
    private BigDecimal productivity;

    @Column(name = "weight")
    private BigDecimal weight;

    @Column(name = "genetic_weight")
    private BigDecimal geneticWeight;

    @Column(name = "age")
    private Integer age;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "nutrients_rate_id")
    private NutrientsEntity nutrients;

    @OneToMany(mappedBy = "geneticGroup", fetch = FetchType.EAGER)
    private List<RationEntity> rations;

    @OneToMany(mappedBy = "geneticGroup", fetch = FetchType.EAGER)
    private List<AnimalPassportEntity> animalPassports;

    @Override
    public String toString(){
        return  "geneticGroupId = " + geneticGroupId + ", " +
                "type = " + type + ", " +
                "productivity = " + productivity + ", " +
                "weight = " + weight + ", " +
                "geneticWeight = " + geneticWeight + ", " +
                "age = " + age + ", " +
                "rations = " + (Objects.isNull(rations) ? 0 : rations.size());
    }
}
