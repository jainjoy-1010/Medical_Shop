package org.example.medical_shop.dto.BillDTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BillRequestDTO {
    private List<BillItemRequestDTO> items;
    private Long userId;
}
