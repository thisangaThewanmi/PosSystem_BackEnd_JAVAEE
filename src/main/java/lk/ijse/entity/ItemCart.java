package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemCart {
    private String orderId;
    private String itemCode;
    private String itemName;
    private int qty;
    private BigDecimal price;
    private BigDecimal total;

}
