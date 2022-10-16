package maluevartem.dao_layer_hibernate_jparepositories.repository;

import lombok.RequiredArgsConstructor;
import maluevartem.dao_layer_hibernate_jparepositories.jpaRepository.PersonCrudRepository;
import maluevartem.dao_layer_hibernate_jparepositories.model.PersonConfirmation;
import maluevartem.dao_layer_hibernate_jparepositories.model.Persons;
import org.springframework.boot.CommandLineRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
@RequiredArgsConstructor
public class Repository implements CommandLineRunner {

    private final PersonCrudRepository personRepository;

    public List<Persons> getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Persons> getPersonsByAge(int age) {
        return personRepository.findByPersonConfirmationAgeLessThanOrderByPersonConfirmationAgeAsc(age);
    }

    public Optional<Persons> getPersonsByNameAndSurname(String name, String surname) {
        return personRepository.findByPersonConfirmationNameAndPersonConfirmationSurname(name, surname);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        fillTable();
    }

    public void fillTable() {
        var names = List.of("Ivan", "Petr", "Olga", "Elena", "Oleg", "Olga");
        var surnames = List.of("Ivanov", "Petrov", "Frolova", "Sidorova", "Semenov", "Filatova");
        var ages = List.of(38, 20, 18, 42, 52, 22);
        var phone_numbers = List.of("8(921)123-00-11", "8(921)123-00-22", "8(921)123-00-33",
                "8(921)123-00-44", "8(921)123-00-55", "8(921)123-00-66");
        var cites = List.of("Moscow", "Moscow", "Orel", "Novosibirsk", "S-Pb", "Moscow");

        for (int i = 0; i < names.size(); i++) {
            var person = Persons.builder()
                    .personConfirmation(PersonConfirmation.builder()
                            .name(names.get(i))
                            .surname(surnames.get(i))
                            .age(ages.get(i))
                            .build())
                    .phoneNumber(phone_numbers.get(i))
                    .cityOfLiving(cites.get(i))
                    .build();

            personRepository.save(person);
        }

    }
}
