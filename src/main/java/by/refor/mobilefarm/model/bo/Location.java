package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Location {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long locationId;
    private String locationIndex;
    private String region;
    private String district;
    private String locationName;
    private String coordinates;
    private String streetName;
    private String houseNumber;
    private String corpusNumber;
    private String flatNumber;
    private String phoneNumber;
    private String faxNumber;
    private String email;
}
