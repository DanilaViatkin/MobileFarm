package by.refor.mobilefarm.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Accessors(chain = true)
public class Nutrients {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long nutrientsId;
    private BigDecimal feedUnit;
    private BigDecimal energyExchange;
    private BigDecimal dryMatter;
    private BigDecimal dryProtein;
    private BigDecimal digestedProtein;
    private BigDecimal rawFat;
    private BigDecimal rawFiber;
    private BigDecimal starch;
    private BigDecimal sugar;
    private BigDecimal lysine;
    private BigDecimal methionineAndCystitis;
    private BigDecimal calcium;
    private BigDecimal phosphorus;
    private BigDecimal magnesium;
    private BigDecimal potassium;
    private BigDecimal sulfur;
    private BigDecimal ferrum;
    private BigDecimal copper;
    private BigDecimal zins;
    private BigDecimal manganese;
    private BigDecimal cobalt;
    private BigDecimal iodine;
    private BigDecimal carotene;
    private BigDecimal vitaminE;
    private BigDecimal vitaminD;
    private BigDecimal salt;

    public Nutrients(){
        feedUnit = BigDecimal.ZERO;
        energyExchange = BigDecimal.ZERO;
        dryMatter = BigDecimal.ZERO;
        dryProtein = BigDecimal.ZERO;
        digestedProtein = BigDecimal.ZERO;
        rawFat = BigDecimal.ZERO;
        rawFiber = BigDecimal.ZERO;
        starch = BigDecimal.ZERO;
        sugar = BigDecimal.ZERO;
        lysine = BigDecimal.ZERO;
        methionineAndCystitis = BigDecimal.ZERO;
        calcium = BigDecimal.ZERO;
        phosphorus = BigDecimal.ZERO;
        magnesium = BigDecimal.ZERO;
        potassium = BigDecimal.ZERO;
        sulfur = BigDecimal.ZERO;
        ferrum = BigDecimal.ZERO;
        copper = BigDecimal.ZERO;
        zins = BigDecimal.ZERO;
        manganese = BigDecimal.ZERO;
        cobalt = BigDecimal.ZERO;
        iodine = BigDecimal.ZERO;
        carotene = BigDecimal.ZERO;
        vitaminE = BigDecimal.ZERO;
        vitaminD = BigDecimal.ZERO;
        salt = BigDecimal.ZERO;
    }
}
