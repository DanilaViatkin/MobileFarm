package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalPassportRepository extends JpaRepository<AnimalPassportEntity, Long> {
    AnimalPassportEntity findByExternalId(String externalId);
    List<AnimalPassportEntity> findByFarm_FarmId(Long farmId);
}
