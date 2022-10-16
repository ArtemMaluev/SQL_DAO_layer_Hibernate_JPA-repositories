package maluevartem.dao_layer_hibernate_jparepositories.controller;

import maluevartem.dao_layer_hibernate_jparepositories.model.Persons;
import maluevartem.dao_layer_hibernate_jparepositories.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class Controller {
    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/by-city")
    public List<Persons> getPersonsByCity(@RequestParam String city) {
        System.out.println(city);
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Persons> getPersonsByAge(@RequestParam int age) {
        System.out.println(age);
        return service.getPersonsByAge(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Persons> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        System.out.println(name + " " + surname);
        return service.getPersonsByNameAndSurname(name, surname);
    }
}
