package com.example.webflux;

import com.example.webflux.entity.Employee;
import com.example.webflux.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class WebflucApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(WebflucApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void appStart() {
        if (employeeRepository.count().block() == 0) {

            IntStream.range(0, 100)
                    .mapToObj(this::generate)
                    .map(employeeRepository::save)
                    .collect(Collectors.toList())
                    .forEach(item -> item.subscribe(System.out::println));
        }
    }

    private Employee generate(int i) {
        return Employee.builder()
                .name("Name" + i)
                .lastName("Lastname" + i)
                .birthDate(LocalDate.now())
                .build();
    }
}
