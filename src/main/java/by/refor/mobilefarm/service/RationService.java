package by.refor.mobilefarm.service;

import by.refor.mobilefarm.model.bo.Nutrients;
import by.refor.mobilefarm.model.bo.Ration;

import java.util.Map;

public interface RationService {
    Map<String, Nutrients> calculateRation(Ration ration, Long geneticGroupId);
}
