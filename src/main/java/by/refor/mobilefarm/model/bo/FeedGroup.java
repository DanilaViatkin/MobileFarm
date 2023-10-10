package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
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
