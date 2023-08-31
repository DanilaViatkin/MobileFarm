package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
}
