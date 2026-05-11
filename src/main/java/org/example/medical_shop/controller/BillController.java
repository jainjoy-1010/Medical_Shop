package org.example.medical_shop.controller;

import org.example.medical_shop.dto.BillDTO.BillItemRespnseDTO;
import org.example.medical_shop.dto.BillDTO.BillRequestDTO;
import org.example.medical_shop.dto.BillDTO.BillResponseDTO;
import org.example.medical_shop.models.Bill;
import org.example.medical_shop.models.BillItem;
import org.example.medical_shop.services.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillController {

    private BillService billService;

    BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/create")
    public BillResponseDTO createBill(@RequestBody BillRequestDTO requestDTO){
        Bill bill = billService.createBill(requestDTO);
        return mapToResponseDTO(bill);
    }

    BillResponseDTO mapToResponseDTO(Bill bill) {
        BillResponseDTO dto = new BillResponseDTO();
        dto.setBillId(bill.getId());
        dto.setTotal(bill.getTotal());
        dto.setDate(bill.getDate());

        List<BillItemRespnseDTO> itemList = new ArrayList<>();

        for (BillItem item : bill.getBillItems()) {

            BillItemRespnseDTO itemDTO = new BillItemRespnseDTO();
            itemDTO.setMedicineId(item.getMedicine().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());

            itemList.add(itemDTO);
        }
        dto.setBillItemList(itemList);
        return dto;
    }

}
