package com.example.service.İmpl;

import com.example.dto.PersonDto;
import com.example.entity.Address;
import com.example.entity.Person;
import com.example.repo.AddressRepository;
import com.example.repo.PersonRepository;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {

        Assert.isNull(personDto.getName(),"Zorunludur");
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLast_name(personDto.getLast_name());
        final Person personDb = personRepository.save(person);
        List<Address> list = new ArrayList<>();

        personDto.getAddresses().forEach(item ->{
            Address address = new Address();
            address.setAddress(item);
            address.setAdressType(Address.AddressType.OTHER);
            address.setStatus(true);
            address.setPerson(personDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        personDto.setId(personDb.getId());
        return personDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        personList.forEach(it ->{
            PersonDto personDto = new PersonDto();
            personDto.setId(it.getId());
            personDto.setName(it.getName());
            personDto.setLast_name(it.getLast_name());
            personDtos.add(personDto);
        });
        return personDtos;
    }

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return null;
    }

}
