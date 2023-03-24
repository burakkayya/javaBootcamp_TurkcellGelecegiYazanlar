package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {
    private BrandRepository repository;

    public BrandManager(BrandRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brand> getAll() {

        if(repository.getAll().size()==0) throw new RuntimeException("Marka Bulunamadı!");
        return repository.getAll();
    }

    @Override
    public Brand getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Brand add(Brand brand) {
        validateBrand(brand);
        return repository.add(brand);
    }

    @Override
    public Brand update(int id, Brand brand) {
        validateBrand(brand);
        return repository.update(id,brand);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
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
