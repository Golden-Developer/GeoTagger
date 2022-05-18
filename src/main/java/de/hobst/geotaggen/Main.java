package de.hobst.geotaggen;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.*;

import java.sql.*;
import java.time.Instant;

public class Main {

    public static void main(String[] args)  {
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBrqZbPz-RfAXPaZMSsfzhfhMKkhlsaxAI").build();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://138.201.202.3:3306/Basti", "Basti", "4711!");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from route");
            while (rs.next()) {
                int plz = rs.getInt("plz");
                int id = rs.getInt("ID");
                String ort = rs.getString("ort");
                System.out.println(id + " " + plz + " " + ort);
                if (rs.getObject("Entfernung") != null) {
                    System.out.println("Übersprungen");
                    continue;
                }
                DirectionsResult result =
                        DirectionsApi.newRequest(context)
                                .origin("21614 Buxtehude lange straße 39 germany")
                                .destination(plz + " " + ort + " germany")
                                .mode(TravelMode.DRIVING)
                                .departureTime(Instant.now())
                                .trafficModel(TrafficModel.BEST_GUESS)
                                .await();
                for (DirectionsRoute route : result.routes) {
                    for (DirectionsLeg leg : route.legs) {
                        System.out.println(leg.distance.humanReadable);

                        Double entf = (double) leg.distance.inMeters / 1000;
                        double roundOff = Math.round(entf * 10.0) / 10.0;
                        System.out.println(entf);
                        System.out.println(roundOff);
                        String query = "update route set Entfernung = ? where ID = ?";
                        PreparedStatement preparedStmt = con.prepareStatement(query);
                        preparedStmt.setDouble(1, roundOff);
                        preparedStmt.setInt(2, id);

                        preparedStmt.executeUpdate();
                    }
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


