package by.refor.mobilefarm.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ration {
    private Long rationId;
    private GeneticGroup geneticGroup;
    private List<Feed> feeds;
}
