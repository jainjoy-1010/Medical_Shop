package org.example.medical_shop.dto.BillDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillItemRespnseDTO {

    private long medicineId;
    private int quantity;
    private double price;

}
