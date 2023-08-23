package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {
}
