package lk.ijse.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.ItemCartBo;
import lk.ijse.dto.ItemCartDto;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/itemCart")
public class ItemCartController extends HttpServlet {

    ItemCartBo itemCartBo = (ItemCartBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ITEMCART);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getContentType().equals("application/json")){

            try(var writer = resp.getWriter()) {

                Jsonb jsonb = JsonbBuilder.create();
                ItemCartDto itemCartDto = jsonb.fromJson(req.getReader(), ItemCartDto.class);
                System.out.println("itemCartDto :"+itemCartDto.toString());

                boolean b = itemCartBo.saveItemCart(itemCartDto);
                if(b){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                   writer.write("itemCartSaved");
                    System.out.println("itemCartSaved");
                }else{
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    writer.write("itemCart not Saved");
                    System.out.println("itemCart not Saved");
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
