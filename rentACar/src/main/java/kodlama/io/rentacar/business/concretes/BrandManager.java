package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.BrandService;
import kodlama.io.rentacar.business.dto.requests.create.CreateBrandRequest;
import kodlama.io.rentacar.business.dto.requests.update.UpdateBrandRequest;
import kodlama.io.rentacar.business.dto.responses.create.CreateBrandResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetAllBrandsResponse;
import kodlama.io.rentacar.business.dto.responses.get.GetBrandResponse;
import kodlama.io.rentacar.business.dto.responses.update.UpdateBrandResponse;
import kodlama.io.rentacar.business.rules.BrandBusinessRules;
import kodlama.io.rentacar.entities.concretes.Brand;
import kodlama.io.rentacar.repository.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository repository;
    private final ModelMapper mapper;
    private final BrandBusinessRules rules;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = repository.findAll();
        List<GetAllBrandsResponse> responses = brands
                .stream()
                .map(brand -> mapper.map(brand, GetAllBrandsResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetBrandResponse getById(int id) {
        rules.checkIfBrandExistsById(id);
        Brand brand = repository.findById(id).orElseThrow();
        GetBrandResponse response = mapper.map(brand, GetBrandResponse.class);
        return response;
    }

    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {

        rules.checkIfBrandExistByName(request.getName());
        Brand brand= mapper.map(request,Brand.class);
        brand.setId(0);
        Brand createdBrand = repository.save(brand);
        CreateBrandResponse response = mapper.map(createdBrand,CreateBrandResponse.class);
        return response;
    }

    @Override
    public UpdateBrandResponse update(int id, UpdateBrandRequest request) {
        rules.checkIfBrandExistsById(id);
        Brand brand = mapper.map(request,Brand.class);
        brand.setId(id);
        Brand updatedBrand = repository.save(brand);
        UpdateBrandResponse response = mapper.map(updatedBrand,UpdateBrandResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfBrandExistsById(id);
        repository.deleteById(id);
    }
    private void validateBrand(Brand brand){
        checkIfNameLengthValid(brand);
        //other validation functions
    }

    private void checkIfNameLengthValid(Brand brand) {
        if(brand.getName().length()<3 || brand.getName().length()>20) throw new IllegalArgumentException("Name lenght must be between 3 and 20 character.");
    }

}
