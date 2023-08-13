package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalPassport {
    private Long animalPassportId;
    private OffsetDateTime createdDate;
    private String id;
    private String type;
    private String nickname;
    private String sex;
    private String breed;
    private OffsetDateTime deathDate;
    private String breedingAnimal;
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
    private OffsetDateTime age;
    @JsonIgnore
    private Farm farm;

    @Override
    public String toString(){
        return  "animalPassportId = " + animalPassportId + ", " +
                "createdDate = " + createdDate + ", " +
                "id = " + id + ", " +
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
                "age = " + age + ", " +
                "farm = " + farm.getName() + ", ";

    }
}
