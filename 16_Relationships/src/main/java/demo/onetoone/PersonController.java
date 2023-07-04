package demo.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PostMapping("addAddress")
    public Person addAddressToPerson(@RequestParam Long personId, @RequestBody Address address) {
        return personService.addAddressToPerson(personId, address);
    }

    @GetMapping("/address/{id}")
    public Address findAddress(@PathVariable Long id) {
        return personService.findAddress(id);
    }

    @GetMapping("/address/person/{addressId}")
    public Person findPersonOfAddress(@PathVariable Long addressId) {
        return personService.findPersonOfAddress(addressId);
    }
}
