package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.Feed;
import by.refor.mobilefarm.model.bo.GeneticGroup;
import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.service.GeneticGroupService;
import by.refor.mobilefarm.service.RationService;
import by.refor.mobilefarm.storage.FeedStorage;
import by.refor.mobilefarm.storage.GeneticGroupStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class RationServiceImpl implements RationService {
    private final FeedStorage feedStorage;
    private final GeneticGroupStorage geneticGroupStorage;
    @Autowired
    public RationServiceImpl(FeedStorage feedStorage,
                             GeneticGroupStorage geneticGroupStorage){
        this.feedStorage = feedStorage;
        this.geneticGroupStorage = geneticGroupStorage;
    }
    @Override
    public Map<String, Nutrients> calculateRation(Ration ration, Long geneticGroupId) {
        Map<String, Nutrients> rationNutrients = new HashMap<>();
        ration.getFeeds()
                .forEach(feed -> rationNutrients.put(feed.getName(), calculateNutrients(feed.getFeedId(), feed.getAmount())));
        GeneticGroup geneticGroup = geneticGroupStorage.getGeneticGroupById(geneticGroupId);
        rationNutrients.put("Всего", sumTotalRationNutrients(ration));
        rationNutrients.put(geneticGroup.getType(), geneticGroup.getNutrients());
        return null;
    }

    private Nutrients calculateNutrients(Long feedId, BigDecimal amount){
        Nutrients feedNutrients = feedStorage.getFeedById(feedId).getNutrients();
        feedNutrients.setFeedUnit(feedNutrients.getFeedUnit().multiply(amount));
        feedNutrients.setEnergyExchange(feedNutrients.getEnergyExchange().multiply(amount));
        feedNutrients.setDryMatter(feedNutrients.getDryMatter().multiply(amount));
        feedNutrients.setDryProtein(feedNutrients.getDryProtein().multiply(amount));
        feedNutrients.setRawFat(feedNutrients.getRawFat().multiply(amount));
        feedNutrients.setRawFiber(feedNutrients.getRawFiber().multiply(amount));
        feedNutrients.setStarch(feedNutrients.getStarch().multiply(amount));
        feedNutrients.setSugar(feedNutrients.getSugar().multiply(amount));
        feedNutrients.setLysine(feedNutrients.getLysine().multiply(amount));
        feedNutrients.setMethionineAndCystitis(feedNutrients.getMethionineAndCystitis().multiply(amount));
        feedNutrients.setCalcium(feedNutrients.getCalcium().multiply(amount));
        feedNutrients.setPhosphorus(feedNutrients.getPhosphorus().multiply(amount));
        feedNutrients.setMagnesium(feedNutrients.getMagnesium().multiply(amount));
        feedNutrients.setPotassium(feedNutrients.getPotassium().multiply(amount));
        feedNutrients.setSulfur(feedNutrients.getSulfur().multiply(amount));
        feedNutrients.setFerrum(feedNutrients.getFerrum().multiply(amount));
        feedNutrients.setCopper(feedNutrients.getCopper().multiply(amount));
        feedNutrients.setZins(feedNutrients.getZins().multiply(amount));
        feedNutrients.setManganese(feedNutrients.getManganese().multiply(amount));
        feedNutrients.setCobalt(feedNutrients.getCobalt().multiply(amount));
        feedNutrients.setIodine(feedNutrients.getIodine().multiply(amount));
        feedNutrients.setCarotene(feedNutrients.getCarotene().multiply(amount));
        feedNutrients.setVitaminE(feedNutrients.getVitaminE().multiply(amount));
        feedNutrients.setVitaminD(feedNutrients.getVitaminD().multiply(amount));
        feedNutrients.setSalt(feedNutrients.getSalt().multiply(amount));
        feedNutrients.setDigestedProtein(feedNutrients.getDigestedProtein().multiply(amount));
        return feedNutrients;
    }

    private Nutrients sumTotalRationNutrients(Ration ration){
        Nutrients feedNutrients = new Nutrients();
        feedNutrients.setFeedUnit(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getFeedUnit().doubleValue()).sum()));
        feedNutrients.setEnergyExchange(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getEnergyExchange().doubleValue()).sum()));
        feedNutrients.setDryMatter(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getDryMatter().doubleValue()).sum()));
        feedNutrients.setDryProtein(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getDryProtein().doubleValue()).sum()));
        feedNutrients.setDigestedProtein(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getDigestedProtein().doubleValue()).sum()));
        feedNutrients.setRawFiber(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getRawFiber().doubleValue()).sum()));
        feedNutrients.setRawFat(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getRawFat().doubleValue()).sum()));
        feedNutrients.setStarch(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getStarch().doubleValue()).sum()));
        feedNutrients.setSugar(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getSugar().doubleValue()).sum()));
        feedNutrients.setLysine(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getLysine().doubleValue()).sum()));
        feedNutrients.setMethionineAndCystitis(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getMethionineAndCystitis().doubleValue()).sum()));
        feedNutrients.setCalcium(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getCalcium().doubleValue()).sum()));
        feedNutrients.setPhosphorus(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getPhosphorus().doubleValue()).sum()));
        feedNutrients.setMagnesium(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getMagnesium().doubleValue()).sum()));
        feedNutrients.setPotassium(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getPotassium().doubleValue()).sum()));
        feedNutrients.setSulfur(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getSulfur().doubleValue()).sum()));
        feedNutrients.setFerrum(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getFerrum().doubleValue()).sum()));
        feedNutrients.setCopper(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getCopper().doubleValue()).sum()));
        feedNutrients.setZins(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getZins().doubleValue()).sum()));
        feedNutrients.setMagnesium(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getManganese().doubleValue()).sum()));
        feedNutrients.setCobalt(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getCobalt().doubleValue()).sum()));
        feedNutrients.setIodine(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getIodine().doubleValue()).sum()));
        feedNutrients.setCarotene(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getCarotene().doubleValue()).sum()));
        feedNutrients.setVitaminE(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getVitaminE().doubleValue()).sum()));
        feedNutrients.setVitaminD(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getVitaminD().doubleValue()).sum()));
        feedNutrients.setSalt(BigDecimal.valueOf(ration.getFeeds().stream().mapToDouble(feed -> feed.getNutrients().getSalt().doubleValue()).sum()));
        return feedNutrients;
    }
}
