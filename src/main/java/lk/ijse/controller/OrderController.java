package lk.ijse.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.OrderBo;
import lk.ijse.bo.impl.OrderBoImpl;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.OrderDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;


@WebServlet("/orders")
public class OrderController extends HttpServlet {

    OrderBo orderBo = (OrderBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ORDER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()){

        if(req.getContentType().equals("application/json")) {

            ArrayList<OrderDto> allOrders = orderBo.getAllOrders();
            Jsonb jsonb = JsonbBuilder.create();
            String json = jsonb.toJson(allOrders);

            writer.write(json);

            if(allOrders.size()>0) {
                System.out.println("all order data retrived");
            }else{
                System.out.println("all order data not retrived");
            }



        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()){

            if(req.getContentType().equals("application/json")){

                System.out.println("json data retrived");


                Jsonb jsonb = JsonbBuilder.create();
                OrderDto orderDto = jsonb.fromJson(req.getReader(), OrderDto.class);
                System.out.println("Order dto:  "+ orderDto.toString() );

                boolean b = orderBo.saveOrder(orderDto);
                System.out.println("b" + b);

                if(b){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    System.out.println("Order saved sucessfully");
                }else{
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    System.out.println("Order placing failed");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }






    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){

            String Id = req.getParameter("orderId");
            if(Id != null) {
                boolean b = orderBo.deleteOrder(Id);

                if(b){
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    writer.write("{\"status\":\"success\"}");
                    resp.getWriter().println("Order deleted");
                }else{
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    resp.getWriter().println("Order not deleted");
                    writer.write("{\"status\":\"failed\"}");
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


