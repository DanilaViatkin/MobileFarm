package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalPassport {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long animalPassportId;
    private OffsetDateTime createdDate;
    private String externalId;
    private String type;
    private String nickname;
    private String sex;
    private String breed;
    private OffsetDateTime deathDate;
    private Boolean breedingAnimal;
    private Double weight;
    private String productionType;
    private Double averageProductivity;
    private Double geneticProductivity;
    private OffsetDateTime treatmentStartDate;
    private OffsetDateTime treatmentEndDate;
    private OffsetDateTime inseminationDate;
    private OffsetDateTime lactationStartDate;
    private OffsetDateTime dryPeriodStartDate;
    private Double weightGrowth;
    private OffsetDateTime birthDate;
    private String motherExternalId;
    private String motherNickname;
    private String fatherExternalId;
    private String fatherNickname;
    private Farm farm;
    private Farm originalOwnerFarm;
    private FeedGroup feedGroup;

    private String originCountry;
    private String externalIdInOriginCountry;
    private Boolean formed;
    private OffsetDateTime formingDate;
    private String  formerName;

    @Override
    public String toString(){
        return  "animalPassportId = " + animalPassportId + ", " +
                "createdDate = " + createdDate + ", " +
                "externalId = " + externalId + ", " +
                "type = " + type + ", " +
                "nickname = " + nickname + ", " +
                "sex = " + sex + ", " +
                "breed = " + breed + ", " +
                "deathDate = " + deathDate + ", " +
                "breedingAnimal = " + breedingAnimal + ", " +
                "weight = " + weight + ", " +
                "productionType = " + productionType + ", " +
                "averageProductivity = " + averageProductivity + ", " +
                "geneticProductivity = " + geneticProductivity + ", " +
                "treatmentStartDate = " + treatmentStartDate + ", " +
                "treatmentEndDate = " + treatmentEndDate + ", " +
                "inseminationDate = " + inseminationDate + ", " +
                "lactationStartDate = " + lactationStartDate + ", " +
                "dryPeriodStartDate = " + dryPeriodStartDate + ", " +
                "weightGrowth = " + weightGrowth + ", " +
                "birthDate = " + birthDate + ", " +
                "geneticGroup = " + feedGroup.getType() + ", " +
                "motherId = " + motherExternalId + ", " +
                "motherNickName = " + motherNickname + ", " +
                "fatherId = " + fatherExternalId + ", " +
                "fatherName = " + fatherNickname + ", " +
                "originCountry = " + originCountry + ", " +
                "externalIdInOriginCountry = " + externalIdInOriginCountry + ", " +
                "formingDate = " +formingDate + ", " +
                "formerName = " +formerName + ", " +
                "farm = " + farm.getName();

    }
}
