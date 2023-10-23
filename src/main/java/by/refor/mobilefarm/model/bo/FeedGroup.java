package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="feedGroupId")
public class FeedGroup {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long feedGroupId;
    private String type;
    private BigDecimal productivity;
    private BigDecimal geneticProductivity;
    private BigDecimal weight;
    private BigDecimal geneticWeight;
    private Integer ageFrom;
    private Integer ageTo;
    private Integer lactationFrom;
    private Integer lactationTo;
    private Integer averageDailyGain;
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Nutrients nutrients;
    private List<Ration> rations;
    private List<AnimalPassport> animalPassports;
}
