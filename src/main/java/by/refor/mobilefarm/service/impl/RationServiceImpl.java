package by.refor.mobilefarm.service.impl;

import by.refor.mobilefarm.model.bo.FeedGroup;
import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.bo.Ration;
import by.refor.mobilefarm.model.dto.CalculatedRation;
import by.refor.mobilefarm.service.RationService;
import by.refor.mobilefarm.storage.FeedStorage;
import by.refor.mobilefarm.storage.FeedGroupStorage;
import by.refor.mobilefarm.storage.RationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class RationServiceImpl implements RationService {
    private final FeedStorage feedStorage;
    private final FeedGroupStorage feedGroupStorage;
    private final RationStorage rationStorage;
    @Autowired
    public RationServiceImpl(FeedStorage feedStorage,
                             FeedGroupStorage feedGroupStorage,
                             RationStorage rationStorage){
        this.feedStorage = feedStorage;
        this.feedGroupStorage = feedGroupStorage;
        this.rationStorage = rationStorage;
    }
    @Override
    public List<CalculatedRation> calculateRation(Ration ration, Long geneticGroupId) {
       List<CalculatedRation> calculatedRations = new ArrayList<>();
        ration.getFeeds()
                .forEach(feed -> calculatedRations.add(new CalculatedRation(feed.getName(), calculateNutrients(feed.getFeedId(), feed.getAmount()))));
        FeedGroup feedGroup = feedGroupStorage.getFeedGroupById(geneticGroupId);
        calculatedRations.add(new CalculatedRation("Всего", sumTotalRationNutrients(calculatedRations)));
        calculatedRations.add(new CalculatedRation(feedGroup.getType(), feedGroup.getNutrients()));
        return calculatedRations;
    }

    @Override
    public void deleteRationById(Long rationId) {
        rationStorage.deleteRationById(rationId);
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

    private Nutrients sumTotalRationNutrients(List<CalculatedRation> calculatedRations){
        Nutrients feedNutrients = new Nutrients();
        calculatedRations.forEach(calculatedRation -> {
                            feedNutrients.setFeedUnit(calculatedRation.getNutrients().getFeedUnit().add(calculatedRation.getNutrients().getFeedUnit()));
                            feedNutrients.setEnergyExchange(calculatedRation.getNutrients().getEnergyExchange().add(calculatedRation.getNutrients().getEnergyExchange()));
                            feedNutrients.setDryMatter(calculatedRation.getNutrients().getDryMatter().add(calculatedRation.getNutrients().getDryMatter()));
                            feedNutrients.setDryProtein(calculatedRation.getNutrients().getDryProtein().add(calculatedRation.getNutrients().getDryProtein()));
                            feedNutrients.setDigestedProtein(calculatedRation.getNutrients().getDigestedProtein().add(calculatedRation.getNutrients().getDigestedProtein()));
                            feedNutrients.setRawFiber(calculatedRation.getNutrients().getRawFiber().add(calculatedRation.getNutrients().getRawFiber()));
                            feedNutrients.setRawFat(calculatedRation.getNutrients().getRawFat().add(calculatedRation.getNutrients().getRawFat()));
                            feedNutrients.setStarch(calculatedRation.getNutrients().getStarch().add(calculatedRation.getNutrients().getStarch()));
                            feedNutrients.setSugar(calculatedRation.getNutrients().getSugar().add(calculatedRation.getNutrients().getSugar()));
                            feedNutrients.setLysine(calculatedRation.getNutrients().getLysine().add(calculatedRation.getNutrients().getLysine()));
                            feedNutrients.setMethionineAndCystitis(calculatedRation.getNutrients().getMethionineAndCystitis().add(calculatedRation.getNutrients().getMethionineAndCystitis()));
                            feedNutrients.setCalcium(calculatedRation.getNutrients().getCalcium().add(calculatedRation.getNutrients().getCalcium()));
                            feedNutrients.setPhosphorus(calculatedRation.getNutrients().getPhosphorus().add(calculatedRation.getNutrients().getPhosphorus()));
                            feedNutrients.setMagnesium(calculatedRation.getNutrients().getMagnesium().add(calculatedRation.getNutrients().getMagnesium()));
                            feedNutrients.setPotassium(calculatedRation.getNutrients().getPotassium().add(calculatedRation.getNutrients().getPotassium()));
                            feedNutrients.setSulfur(calculatedRation.getNutrients().getSulfur().add(calculatedRation.getNutrients().getSulfur()));
                            feedNutrients.setFerrum(calculatedRation.getNutrients().getFerrum().add(calculatedRation.getNutrients().getFerrum()));
                            feedNutrients.setCopper(calculatedRation.getNutrients().getCopper().add(calculatedRation.getNutrients().getCopper()));
                            feedNutrients.setZins(calculatedRation.getNutrients().getZins().add(calculatedRation.getNutrients().getZins()));
                            feedNutrients.setMagnesium(calculatedRation.getNutrients().getMagnesium().add(calculatedRation.getNutrients().getMagnesium()));
                            feedNutrients.setCobalt(calculatedRation.getNutrients().getCobalt().add(calculatedRation.getNutrients().getCobalt()));
                            feedNutrients.setIodine(calculatedRation.getNutrients().getIodine().add(calculatedRation.getNutrients().getIodine()));
                            feedNutrients.setCarotene(calculatedRation.getNutrients().getCarotene().add(calculatedRation.getNutrients().getCarotene()));
                            feedNutrients.setVitaminE(calculatedRation.getNutrients().getVitaminE().add(calculatedRation.getNutrients().getVitaminE()));
                            feedNutrients.setVitaminD(calculatedRation.getNutrients().getVitaminD().add(calculatedRation.getNutrients().getVitaminD()));
                            feedNutrients.setSalt(calculatedRation.getNutrients().getSalt().add(calculatedRation.getNutrients().getSalt()));
                        });
        return feedNutrients;
    }
    @Override
    public List<Integer> findByOrganizationName(String organizationName)
    {
        return rationStorage.findByOrganizationName(organizationName);
    };

    @Override
    public List<Ration> getAll() {
        return rationStorage.getAll();
    }
}
