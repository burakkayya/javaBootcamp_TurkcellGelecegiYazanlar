package kodlama.io.rentacar.business.abstracts;

import kodlama.io.rentacar.entities.concretes.Car;
import kodlama.io.rentacar.entities.concretes.Model;

import java.util.List;

public interface ModelService {
    List<Model> getAll();
    Model getById(int id);
    Model add(Model model);
    Model update(int id, Model model);
    void  delete(int id);
}
