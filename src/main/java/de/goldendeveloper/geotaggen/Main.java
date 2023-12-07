package de.goldendeveloper.geotaggen;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;

import java.io.IOException;
import java.sql.*;
import java.time.Instant;

public class Main {

    private static Config config;
    private static GeoApiContext context;

    public static void main(String[] args) {
        config = new Config();
        context = new GeoApiContext.Builder().apiKey(config.getApiKey()).build();

        try (Connection con = createDatabaseConnection()) {
            processRoutes(con);
        } catch (SQLException e) {
            handleDatabaseError(e);
        } catch (ApiException | InterruptedException | IOException e) {
            handleApiError(e);
        }
    }

    private static Connection createDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(config.getDbUrl(), config.getDbUser(), config.getDbPassword());
    }

    private static void processRoutes(Connection con) throws SQLException, ApiException, InterruptedException, IOException {
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM route")) {
            while (rs.next()) {
                processSingleRoute(con, rs);
            }
        }
    }

    private static void processSingleRoute(Connection con, ResultSet rs) throws SQLException, ApiException, InterruptedException, IOException {
        int plz = rs.getInt("plz");
        int id = rs.getInt("ID");
        String ort = rs.getString("ort");
        System.out.println(id + " " + plz + " " + ort);

        if (rs.getObject("Entfernung") == null) {
            calculateAndUpdateDistance(con, id, plz, ort);
        }
    }

    private static void calculateAndUpdateDistance(Connection con, int id, int plz, String ort) throws ApiException, InterruptedException, IOException, SQLException {
        DirectionsResult result = DirectionsApi.newRequest(context)
                .origin("21614 Buxtehude lange straße 39 germany")
                .destination(plz + " " + ort + " germany")
                .mode(TravelMode.DRIVING)
                .departureTime(Instant.now())
                .trafficModel(TrafficModel.BEST_GUESS)
                .await();

        for (DirectionsRoute route : result.routes) {
            for (DirectionsLeg leg : route.legs) {
                updateDistanceInDatabase(con, id, leg.distance.inMeters);
            }
        }
    }

    private static void updateDistanceInDatabase(Connection con, int id, long distanceMeters) throws SQLException {
        double distanceKm = Math.round((distanceMeters / 1000.0) * 10.0) / 10.0;
        System.out.println(distanceKm + " km");
        String query = "UPDATE route set Entfernung = ? where ID = ?";
        try (PreparedStatement preparedStmt = con.prepareStatement(query)) {
            preparedStmt.setDouble(1, distanceKm);
            preparedStmt.setInt(2, id);
            preparedStmt.executeUpdate();
        }
    }

    private static void handleDatabaseError(SQLException e) {
        System.err.println("Datenbankfehler: " + e.getMessage());
    }

    private static void handleApiError(Exception e) {
        System.err.println("API-Fehler: " + e.getMessage());
    }
}


