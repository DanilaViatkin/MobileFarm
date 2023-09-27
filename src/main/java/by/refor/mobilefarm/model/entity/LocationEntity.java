package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locations")
@Data
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @Column(name = "location_index", nullable = false)
    private String locationIndex;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @Column(name = "coordinates", nullable = false)
    private String coordinates;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "house_number", nullable = false)
    private String houseNumber;

    @Column(name = "corpus_number")
    private String corpusNumber;

    @Column(name = "flat_number")
    private String flatNumber;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "fax_number")
    private String faxNumber;

    @Column(name = "email", nullable = false)
    private String email;
}
