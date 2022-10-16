package maluevartem.dao_layer_hibernate_jparepositories.jpaRepository;

import maluevartem.dao_layer_hibernate_jparepositories.model.Persons;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PersonCrudRepository extends JpaRepository<Persons, Long> {

    @Query("select p from Persons p where p.cityOfLiving = :city")
    List<Persons> selectEntityByCity(@Param("city") String city);

    @Query("select p from Persons p where p.personConfirmation.age < :age")
    List<Persons> selectEntityByAge(@Param("age") int age, Sort sort);

    @Query("select p from Persons p where p.personConfirmation.name = :name and p.personConfirmation.surname = :surname")
    Optional<Persons> selectEntityByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
