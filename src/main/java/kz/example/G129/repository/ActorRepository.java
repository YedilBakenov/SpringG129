package kz.example.G129.repository;

import kz.example.G129.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
