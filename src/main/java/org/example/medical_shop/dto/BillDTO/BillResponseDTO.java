package org.example.medical_shop.dto.BillDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BillResponseDTO {
    private long billId;
    private double total;
    private Date date;
    private List<BillItemRespnseDTO> billItemList;
}
