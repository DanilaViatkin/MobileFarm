package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Feed {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long feedId;
    private String name;
    private String type;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private BigDecimal amount;
    private Nutrients nutrients;
}
