package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class GeneticGroup {
    private Long geneticGroupId;
    private String type;
    private BigDecimal productivity;
    private BigDecimal weight;
    private BigDecimal geneticWeight;
    private Integer age;
    private Nutrients nutrients;
    private List<Ration> rations;
    @JsonIgnore
    public Nutrients getNutrients(){
        return nutrients;
    }
}
