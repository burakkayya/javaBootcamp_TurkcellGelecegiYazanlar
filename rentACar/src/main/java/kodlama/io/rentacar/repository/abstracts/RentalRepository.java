package kodlama.io.rentacar.repository.abstracts;

import kodlama.io.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
//    @Transactional
//    void deleteByRentalId(int rentalId);
}

