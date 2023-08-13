package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farm {
    private Long farmId;
    private String gln;
    private OffsetDateTime registrationDate;
    private String name;
    private OffsetDateTime formingDate;
    private Owner owner;
    private Location location;
    private List<AnimalPassport> animalPassports;
    @JsonIgnore
    private Organization organization;
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
                "animalPassports = " + animalPassports.size() + ", " +
                "organization = " + organization.getName() + ", " +
                "animalAmount = " + animalAmount + ", ";
    }
}
