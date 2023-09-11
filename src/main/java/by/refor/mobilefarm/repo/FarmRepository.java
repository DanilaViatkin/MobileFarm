package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FarmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmRepository extends JpaRepository<FarmEntity, Long> {
    Optional<FarmEntity> findByGln(String gln);

    List<FarmEntity> findByOrganization_OrganizationId(Long organizationId);
}
