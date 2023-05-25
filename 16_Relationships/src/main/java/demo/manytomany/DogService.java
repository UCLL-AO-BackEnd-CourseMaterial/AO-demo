package demo.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {
    @Autowired
    private DogRepo dogRepo;

    @Autowired
    private ToyRepo toyRepo;

    public Dog addDog(Dog dog) {
        return dogRepo.save(dog);
    }

    public Dog removeDog(Long dogId) {
        Dog dog = dogRepo.findById(dogId).orElse(null);
        dog.getFavoriteToys().clear();
        dogRepo.save(dog);
        dogRepo.delete(dog);
        return dog;
    }

    public Dog addToyToDog(Long dogId, Toy toy) {
        Dog dog = dogRepo.findById(dogId).orElse(null);
        dog.addToy(toy);
        toyRepo.save(toy);
        return dogRepo.save(dog);
    }
}
