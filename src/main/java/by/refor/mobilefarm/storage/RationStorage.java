package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Ration;

public interface RationStorage {
    Ration createRation(Ration ration, Long feedGroupId);
    void deleteRationById(Long rationId);
}
