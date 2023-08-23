package by.refor.mobilefarm.repo;

import by.refor.mobilefarm.model.entity.GeneticGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface GeneticGroupRepository extends JpaRepository<GeneticGroupEntity, Long> {
    GeneticGroupEntity findByTypeAndProductivityAndWeightAndGeneticWeightAndAge(String type, BigDecimal productivity, BigDecimal weight, BigDecimal geneticWeight, Integer age);
}
