package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> responses = new ArrayList<>();
        for (Brand brand : brands) {
            responses.add(new GetAllBrandsResponse(brand.getId(), brand.getName()));
        }
        return responses;
    }

    @Override
    public GetBrandResponse getById(int id) {
        checkIfBrandExists(id);
        Brand brand = repository.findById(id).orElseThrow();
        GetBrandResponse response = new GetBrandResponse();
        response.setName(brand.getName());
        response.setId(brand.getId());
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        repository.save(brand);

        CreateBrandResponse response = new CreateBrandResponse();
        response.setId(brand.getId());
        response.setName(brand.getName());
        return response;
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
        //other validation functions
    }

    private void checkIfNameLengthValid(Brand brand) {
        if(brand.getName().length()<3 || brand.getName().length()>20) throw new IllegalArgumentException("Name lenght must be between 3 and 20 character.");
    }

}
