package kz.example.G129.repository2;

import kz.example.G129.model2.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AwardRepository extends JpaRepository<Award, Integer> {
}
