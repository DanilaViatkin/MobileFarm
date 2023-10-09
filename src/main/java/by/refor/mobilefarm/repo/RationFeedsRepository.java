package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.RationFeedKey;
import by.refor.mobilefarm.model.entity.RationFeeds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface RationFeedsRepository extends JpaRepository<RationFeeds, RationFeedKey> {
}
