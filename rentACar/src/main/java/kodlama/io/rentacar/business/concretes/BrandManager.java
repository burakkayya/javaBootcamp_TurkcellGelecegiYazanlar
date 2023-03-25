package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;

    @Override
    public List<Brand> getAll() {
        return repository.findAll();
    }

    @Override
    public Brand getById(int id) {
        checkIfBrandExists(id);
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Brand add(Brand brand) {
        return repository.save(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        checkIfBrandExists(id);
        brand.setId(id);
        return repository.save(brand);
    }

    @Override
    public void delete(int id) {
        checkIfBrandExists(id);
        repository.deleteById(id);
    }

    //Business rules

    private void checkIfBrandExists(int id){
        if(!repository.existsById(id)) throw new RuntimeException("Böyle bir marka mevcut değil!");
    }
    private void validateBrand(Brand brand){
        checkIfNameLengthValid(brand);
        checkIfSloganLengthValid(brand);
    }

    private void checkIfNameLengthValid(Brand brand) {
        if(brand.getName().length()<3 || brand.getName().length()>20) throw new IllegalArgumentException("Name lenght must be between 3 and 20 character.");
    }

    private void checkIfSloganLengthValid(Brand brand) {
        if(brand.getSlogan().length()<5 || brand.getSlogan().length()>50) throw new IllegalArgumentException("Slogan lenght must be between 5 and 50 character.");
    }
}
