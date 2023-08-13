package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalPassportsRepository extends JpaRepository<AnimalPassportEntity, Long> {
}
