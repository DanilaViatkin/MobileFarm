package by.refor.mobilefarm.model.dto;

import by.refor.mobilefarm.model.bo.Nutrients;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatedRation {
    private String parameterName;
    private Nutrients nutrients;
}
