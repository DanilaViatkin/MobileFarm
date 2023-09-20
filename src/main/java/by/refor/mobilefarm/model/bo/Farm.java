package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long farmId;
    private String gln;
    private OffsetDateTime registrationDate;
    private String name;
    private OffsetDateTime formingDate;
    private Owner owner;
    private Location location;
    private String organizationName;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<AnimalPassport> animalPassports;
    private Long animalAmount;
    private Long bullAmount;
    private Long heiferAmount;
    private Long cowAmount;
    private Long dryResistantAmount;
    private Long netelAmount;
    private Boolean isFormed;
    private String formerName;

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
