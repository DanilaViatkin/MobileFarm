package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FeedEntity;
import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

    @Query("SELECT feed FROM FeedEntity feed\n" +
            "INNER JOIN RationFeeds rf ON feed.feedId = rf.ration.rationId\n" +
            "INNER JOIN RationEntity  r ON rf.ration.rationId = r.rationId\n" +
            "INNER JOIN FeedGroupEntity g ON r.feedGroup.feedGroupId = g.feedGroupId\n" +
            "INNER JOIN AnimalPassportEntity a ON g.feedGroupId = a.feedGroup.feedGroupId\n" +
            "INNER JOIN FarmEntity f ON a.farm.farmId = f.farmId\n" +
            "WHERE f.organization.name = ?1")
    List<FeedEntity> findByOrganizationName(String organization);

}
