package kodlama.io.rentacar.business.dto.requests.create;

import kodlama.io.rentacar.business.dto.PaymentRequest;
import kodlama.io.rentacar.entities.concretes.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRentalRequest {
    private int carId;
    private double dailyPrice;
    private int rentedForDays;
    private PaymentRequest paymentRequest;
}
