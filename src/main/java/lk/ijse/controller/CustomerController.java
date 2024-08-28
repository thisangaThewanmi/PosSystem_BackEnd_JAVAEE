package lk.ijse.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.CustomerBo;

import lk.ijse.dto.CustomerDto;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/customer")
public class CustomerController extends HttpServlet {

    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.CUSTOMER);

    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       try(var writer = resp.getWriter()){
           ArrayList<CustomerDto> allCustomer = null;

           Jsonb jsonb = JsonbBuilder.create();



           try {
               allCustomer = customerBo.getAllCustomer();
               String json = jsonb.toJson(allCustomer);
               resp.getWriter().write(json); // Write only the JSON to response

               if(allCustomer.size() > 0){
                   System.out.println("All DataRetrived");
               }else{
                   System.out.println("All DataRetrived nooo........");
               }
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }




       }
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()){

            if(req.getContentType().equals("application/json")){
                Jsonb jsonb = JsonbBuilder.create();
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

                boolean b = customerBo.saveCustomer(customerDto);

                if(b){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    writer.write("Customer saved sucessfully");
                }else{
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    writer.write("Customer saving failed");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()){

            if(req.getContentType().equals("application/json")){

                String id = req.getParameter("id");

                Jsonb jsonb = JsonbBuilder.create();
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);

                boolean b = false;
                try {
                    b = customerBo.updateCustomer(id, customerDto);

                if(b){
                    resp.setStatus(HttpServletResponse.SC_CREATED);
                    writer.write("Customer updated sucessfully");
                }else{
                    resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                    writer.write("Customer update failed");
                }

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }


        }
    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()){

                String id = req.getParameter("id");
                try {
                    boolean b = customerBo.deleteCustomer(id);

                    if(b){
                        writer.write("Customer deleted sucessfully");
                        System.out.println("dle");
                    }else{
                        writer.write("Customer delete failed");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


        }
    }
}

