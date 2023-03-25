package kodlama.io.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "brands")
public class Brand {
    @Id // Primary Key
    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(name = "name")
    private String name;
    //@Column(name = "slogan")
    private String slogan;

}
