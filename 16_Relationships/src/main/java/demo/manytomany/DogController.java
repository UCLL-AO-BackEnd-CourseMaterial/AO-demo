package demo.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @PostMapping("/{dogId}/toy")
    public Dog addToyToDog(@PathVariable("dogId") Long dogId,
            @RequestBody Toy toy) {
        return dogService.addToyToDog(dogId, toy);
    }

    @DeleteMapping("/{dogId}")
    public Dog removeDog(@PathVariable("dogId") Long dogId) {
        return dogService.removeDog(dogId);
    }
}
