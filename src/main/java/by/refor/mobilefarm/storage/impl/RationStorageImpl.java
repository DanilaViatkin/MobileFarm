package by.refor.mobilefarm.storage.impl;

import by.refor.mobilefarm.repo.RationRepository;
import by.refor.mobilefarm.storage.RationStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RationStorageImpl implements RationStorage {

    private final RationRepository rationRepository;

    @Autowired
    public RationStorageImpl(RationRepository rationRepository) {
        this.rationRepository = rationRepository;
    }
    @Override
    public void deleteRationById(Long rationId) {
        rationRepository.delete(rationRepository.findById(rationId).get());
    }
}
