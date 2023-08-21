package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Farm {
    private Long farmId;
    private String gln;
    private OffsetDateTime registrationDate;
    private String name;
    private OffsetDateTime formingDate;
    private Owner owner;
    private Location location;
    private String organizationName;
    private Long animalAmount;

    @Override
    public String toString() {
        return  "farmId = " + farmId + ", " +
                "gln = " + gln + ", " +
                "registrationDate = " + registrationDate + ", " +
                "name = " + name + ", " +
                "formingDate = " + formingDate + ", " +
                "owner = " + owner.getFirstName() + " " + owner.getLastName() + ", " +
                "location = " + location.getCoordinates() + ", " +
                "organizationName = " + organizationName + ", " +
                "animalAmount = " + animalAmount + ", ";
    }
}
