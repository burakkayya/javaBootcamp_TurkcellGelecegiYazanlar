package kodlama.io.rentacar.entities.concretes;

import jakarta.persistence.*;
import kodlama.io.rentacar.entities.concretes.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int modelYear;
    private double dailyPrice;
    private String  plate;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    @JoinColumn(name="model_id")
    private Model model;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

}
