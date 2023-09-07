package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long organizationId;
    private String gln;
    private OffsetDateTime registrationDate;
    private String name;
    private String shortName;
    private String unp;
    private String okpo;
    private String egr;
    private OffsetDateTime createdDate;
    private String bankCode;
    private String paymentAccount;
    private Owner owner;
    private Location location;
    private List<Farm> farms;

    @Override
    public String toString(){
        return "organizationId = " + organizationId + ", " +
                "gln = " + gln + ", " +
                "registrationDate = " + registrationDate + ", " +
                "name = " + name + ", " +
                "shortName = " + shortName + ", " +
                "unp = " + unp + ", " +
                "okpo = " + okpo + ", " +
                "egr = " + egr + ", " +
                "createdDate = " + createdDate + ", " +
                "bankCode = " + bankCode + ", " +
                "paymentAccount = " + paymentAccount + ", " +
                "owner = " + owner.getFirstName() + " " + owner.getLastName() + ", " +
                "location = " + location.getCoordinates() + ", " +
                "farms = " + farms.size();
    }


}
