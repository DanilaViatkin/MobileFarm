package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import by.refor.mobilefarm.model.entity.RationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RationRepository extends JpaRepository<RationEntity, Long> {

    @Query("SELECT r.rationId FROM RationEntity r\n" +
            "INNER JOIN FeedGroupEntity g ON r.feedGroup.feedGroupId = g.feedGroupId\n" +
            "INNER JOIN AnimalPassportEntity a ON g.feedGroupId = a.feedGroup.feedGroupId\n" +
            "INNER JOIN FarmEntity f ON a.farm.farmId = f.farmId\n" +
               "WHERE f.organization.name = ?1")
    List<Integer> findByOrganizationName(String organization);
}
