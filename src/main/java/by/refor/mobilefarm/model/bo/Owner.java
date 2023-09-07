package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long ownerId;
    private String firstName;
    private String middleName;
    private String lastName;
}
