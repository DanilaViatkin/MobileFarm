package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Ration;

import java.util.List;

public interface RationStorage {
    Ration createRation(Ration ration, Long feedGroupId);
    void deleteRationById(Long rationId);
    List<Ration> findByOrganizationName(String organization);

    List <Ration> getAll();
}
