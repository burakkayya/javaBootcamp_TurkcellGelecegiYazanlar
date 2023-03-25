package kodlama.io.rentacar.repository.abstracts;

import kodlama.io.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    //Custom queries
}
