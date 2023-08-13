package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, Long> {
    FarmEntity findByGln(String gln);
}
