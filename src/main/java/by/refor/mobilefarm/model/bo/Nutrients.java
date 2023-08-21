package by.refor.mobilefarm.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nutrients {
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
}
