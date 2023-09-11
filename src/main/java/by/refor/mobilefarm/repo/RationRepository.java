package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.RationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RationRepository extends JpaRepository<RationEntity, Long> {
}
