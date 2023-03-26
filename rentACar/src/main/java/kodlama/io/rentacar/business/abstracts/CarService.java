package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.entities.concretes.Car;

import java.util.List;

public interface CarService {

    List<Car> getAll();
    Car getById(int id);
    Car add(Car car);
    Car update(int id, Car car);
    void  delete(int id);
}
