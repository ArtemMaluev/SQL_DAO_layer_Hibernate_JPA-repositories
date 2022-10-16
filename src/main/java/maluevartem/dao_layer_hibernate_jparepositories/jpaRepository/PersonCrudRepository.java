package maluevartem.dao_layer_hibernate_jparepositories.jpaRepository;

import maluevartem.dao_layer_hibernate_jparepositories.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonCrudRepository extends JpaRepository<Persons, Long> {

    List<Persons> findByCityOfLiving(String city);

    List<Persons> findByPersonConfirmationAgeLessThanOrderByPersonConfirmationAgeAsc(int age);

    Optional<Persons> findByPersonConfirmationNameAndPersonConfirmationSurname(String name, String surname);
}
