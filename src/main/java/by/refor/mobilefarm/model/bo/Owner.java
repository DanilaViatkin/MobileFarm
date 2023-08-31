package by.refor.mobilefarm.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner {
    private Long ownerId;
    private String firstName;
    private String middleName;
    private String lastName;
}
