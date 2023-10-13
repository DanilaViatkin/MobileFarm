package by.refor.mobilefarm.storage;

import by.refor.mobilefarm.model.bo.Ration;

import java.util.List;

public interface RationStorage {
    void deleteRationById(Long rationId);
    List<Integer> findByOrganizationName(String organization);

    List<Ration> getAll();
}
