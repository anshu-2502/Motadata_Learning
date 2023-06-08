package Database;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Databaseh2 extends AbstractVerticle {

    EventBus eventBus;
    public void start(Promise<Void> startPromise) {

        try {

            ConnectionPool.createConnectionPool(10);

            eventBus = vertx.eventBus();

            eventBus.consumer("insert").handler(this::insertDevice);

            eventBus.consumer("select").handler(this::selectData);

        }
        catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void insertDevice(Message message){

        try {

            Connection connection=ConnectionPool.getConnection();

            JsonObject userData = (JsonObject) message.body();

            System.out.println(userData);

            String deviceip  = userData.getString("deviceip");

            System.out.println(deviceip);

            String devicename = userData.getString("devicename");

            String devicetype = userData.getString("type");

            String credentials= userData.getString("credentials");



            PreparedStatement preparedStatement = connection.prepareStatement( "INSERT INTO discoverytable (device_ip, device_name, device_type, credentials) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, deviceip);

            preparedStatement.setString(2, devicename);

            preparedStatement.setString(3, devicetype);

            preparedStatement.setString(4, credentials);

            preparedStatement.execute();

            System.out.println("inserted successfully");


        }catch (Exception exception){

            exception.printStackTrace();

        }
    }


    private void selectData(Message message){

        try{

            Connection connection=ConnectionPool.getConnection();

            if(connection!=null) {

                ArrayList<Map<String, Object>> result = new ArrayList<>();



                PreparedStatement preparedStatement = connection.prepareStatement("select * from DISCOVERYTABLE ");

                ResultSet resultSet = preparedStatement.executeQuery();

                while(resultSet.next()){


                    Map<String, Object> map = new HashMap<>();

                    map.put("device_id", resultSet.getString("device_id"));

                    map.put("device_ip" , resultSet.getString("device_ip"));

                    map.put("device_name", resultSet.getString("device_name"));

                    map.put("device_type", resultSet.getString("device_type"));

                    result.add(map);



                }

                message.reply(new JsonArray(result));

            }
            else{
                System.out.println("not connected");

                message.fail(500, "An error occurred while retrieving data from the database.");

            }

        }

        catch(Exception e){


            e.printStackTrace();
        }



    }



}
