package com.example.ecommerce.business.dto.requests.update;

import com.example.ecommerce.entities.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private String name;
    private  int quantity;
    private double unitPrice;
    private String description;
    private Status status;
}
