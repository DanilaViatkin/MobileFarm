package by.refor.mobilefarm.model.bo;

import lombok.Data;

@Data
public class Location {
    private String index;
    private String region;
    private String district;
    private String locationName;
    private String coordinates;
    private String streetName;
    private String houseNumber;
    private String corpusNumber;
    private String phoneNumber;
    private String faxNumber;
    private String email;
}
