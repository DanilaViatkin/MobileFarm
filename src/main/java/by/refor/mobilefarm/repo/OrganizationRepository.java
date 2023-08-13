package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
    OrganizationEntity findByGln(String gln);
    OrganizationEntity findByUnp(String unp);
}
