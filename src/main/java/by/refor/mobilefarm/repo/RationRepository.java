package by.refor.mobilefarm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RationRepository extends JpaRepository<RationRepository, Long> {
}
