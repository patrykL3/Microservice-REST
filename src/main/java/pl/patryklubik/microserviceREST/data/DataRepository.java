package pl.patryklubik.microserviceREST.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by Patryk Łubik on 08.04.2021.
 */

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
}
