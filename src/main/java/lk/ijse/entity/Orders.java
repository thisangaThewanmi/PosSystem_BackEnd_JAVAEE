package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Orders  {
    private String orderID;

    private String orderDate;

    private String customerId;

    private String customerName;

    private BigDecimal total;

    private BigDecimal discount;

    private BigDecimal subtotal;
}
