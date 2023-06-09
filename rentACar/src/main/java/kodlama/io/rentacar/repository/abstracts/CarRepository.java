package kodlama.io.rentacar.repository.abstracts;

import kodlama.io.rentacar.entities.concretes.Car;
import kodlama.io.rentacar.entities.concretes.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findAllByStateIsNot(State state);
    boolean existsByPlate(String plate);
}
