package demo.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private AddressRepo addressRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public Person findPerson(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    public Person addAddressToPerson(Long personId, Address address) {
        Person person = findPerson(personId);
        person.setAddress(address);
        addressRepo.save(address);
        personRepo.save(person);
        return person;
    }
}
