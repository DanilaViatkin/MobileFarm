package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "farms")
@Data
public class FarmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long farmId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "organization_id", nullable = false)
    private OrganizationEntity organization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private OwnerEntity owner;

    @OneToMany(mappedBy = "farm")
    private List<AnimalPassportEntity> animalPassports;

    @Column(name = "gln", nullable = false)
    private String gln;

    @Column(name = "registration_date", nullable = false)
    private OffsetDateTime registrationDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "forming_date", nullable = false)
    private OffsetDateTime formingDate;

    @Column(name = "is_formed", nullable = false)
    private Boolean isFormed;

    @Column(name = "former_name", nullable = false)
    private String formerName;
}
