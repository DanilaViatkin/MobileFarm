package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ration {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long rationId;
    private GeneticGroup geneticGroup;
    private List<Feed> feeds;
}
