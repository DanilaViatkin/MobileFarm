package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.FeedGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface FeedGroupRepository extends JpaRepository<FeedGroupEntity, Long> {

    FeedGroupEntity findByTypeAndProductivityAndWeightAndGeneticWeightAndAgeTo(String type, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight, Integer ageTo);
}
