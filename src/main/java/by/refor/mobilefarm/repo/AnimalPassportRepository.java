package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.AnimalPassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnimalPassportRepository extends JpaRepository<AnimalPassportEntity, Long> {
    Optional<AnimalPassportEntity> findByExternalId(String externalId);
    List<AnimalPassportEntity> findByFarm_FarmId(Long farmId);

    @Query("SELECT ap FROM OrganizationEntity o\n" +
            "INNER JOIN FarmEntity f ON o.organizationId = f.organization.organizationId\n" +
            "INNER JOIN AnimalPassportEntity ap ON f.farmId = ap.farm.farmId\n" +
            "WHERE o.organizationId = ?1")
    List<AnimalPassportEntity> findByOrganizationId(Long organizationId);
}
