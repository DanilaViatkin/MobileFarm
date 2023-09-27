package by.refor.mobilefarm.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "organizations")
@Data
public class OrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private OwnerEntity owner;

    @OneToMany(mappedBy = "organization")
    private List<FarmEntity> farms;

    @Column(name = "gln", nullable = false)
    private String gln;

    @Column(name = "registration_date", nullable = false)
    private OffsetDateTime registrationDate;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "unp", nullable = false)
    private String unp;

    @Column(name = "okpo", nullable = false)
    private String okpo;

    @Column(name = "egr", nullable = false)
    private String egr;

    @Column(name = "created_date", nullable = false)
    private OffsetDateTime createdDate;

    @Column(name = "bank_code", nullable = false)
    private String bankCode;

    @Column(name = "payment_account", nullable = false)
    private String paymentAccount;
}
