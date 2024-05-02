package they.tech.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import they.tech.api.models.Pizza;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
