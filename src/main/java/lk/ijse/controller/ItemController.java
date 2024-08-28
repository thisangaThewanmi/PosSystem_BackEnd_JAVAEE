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
import lk.ijse.bo.ItemBo;
import lk.ijse.dao.DaoFactory;
import lk.ijse.dto.CustomerDto;
import lk.ijse.dto.ItemDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/item")
public class ItemController extends HttpServlet {

    ItemBo itemBO = (ItemBo) BoFactory.getBoFactory().getBo(BoFactory.BOTypes.ITEM);
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            try(var writer = resp.getWriter()){
                ArrayList<ItemDto> allItems = null;

                Jsonb jsonb = JsonbBuilder.create();



                try {
                    allItems = itemBO.getAllItems();
                    String json = jsonb.toJson(allItems);
                    resp.getWriter().write(json); // Write only the JSON to response

                    if(allItems.size() > 0){
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
                    ItemDto itemDto = jsonb.fromJson(req.getReader(),ItemDto.class);

                    boolean b = itemBO.saveItem(itemDto);

                    if(b){
                        resp.setStatus(HttpServletResponse.SC_CREATED);
                        writer.write("Item saved sucessfully");
                    }else{
                        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                        writer.write("Item saving failed");
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
                    ItemDto itemDto = jsonb.fromJson(req.getReader(),ItemDto.class);

                    boolean b = false;
                    try {
                        b = itemBO.updateItem(id,itemDto);

                        if(b){
                            resp.setStatus(HttpServletResponse.SC_CREATED);
                            writer.write("Item updated sucessfully");
                        }else{
                            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                            writer.write("Item update failed");
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
                    boolean b = itemBO.deleteItem(id);

                    if(b){
                        writer.write("Item deleted sucessfully");
                        System.out.println("dle");
                    }else{
                        writer.write("Item delete failed");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


            }
        }
    }


