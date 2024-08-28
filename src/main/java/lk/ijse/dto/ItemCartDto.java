package lk.ijse.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemCartDto {
    private String orderId;
    private String itemCode;
    private String itemName;
    private int qty;
    private BigDecimal price;
    private BigDecimal total;

    @Override
    public String toString() {
        return "ItemCartDto{" +
                "orderId='" + orderId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
