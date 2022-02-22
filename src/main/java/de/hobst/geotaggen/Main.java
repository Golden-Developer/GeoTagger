package de.hobst.geotaggen;

import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.*;
import de._Coho04_.mysql.MYSQL;
import de._Coho04_.mysql.entities.Database;
import de._Coho04_.mysql.entities.Table;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ApiException {
        String DatabaseName = "Basti";
        String TabelName = "route";
        MYSQL mysql = new MYSQL("138.201.202.3", "Basti", "4711!", 3306);
//        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBWtdzqzuvBU4j6KBp5dKqh2-tR4lslSx4").build();
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBrqZbPz-RfAXPaZMSsfzhfhMKkhlsaxAI").build();

        if (mysql.existsDatabase(DatabaseName)) {
            Database db = mysql.getDatabase(DatabaseName);
            if (db.existsTable(TabelName)) {
                Table table = db.getTable(TabelName);
                for (String item : fillList()) {
                    HashMap mp = table.getRow(table.getColumn("ort"), item);
                    String plz = (String) mp.get("plz");
                    String ort = item;


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
                        }
                    }
                }
            }
        }
    }


    public static List<String> fillList() {
        List l = new ArrayList<String>();
        l.add("Barver");
        l.add("Dickel");
        l.add("Hemsloh");
        l.add("Rehden");
        l.add("Wetschen");
        l.add("Bakum");
        l.add("Drebber");
        l.add("Lembruch");
        l.add("Bramsche");
        l.add("Ankum");
        l.add("Eggermühlen");
        l.add("Kettenkamp");
        l.add("Fürstenau");
        l.add("Merzen");
        l.add("Neuenkirchen (Landkreis Osnabrück)");
        l.add("Bersenbrück");
        l.add("Alfhausen");
        l.add("Gehrde");
        l.add("Rieste");
        l.add("Voltlage");
        l.add("Quakenbrück");
        l.add("Löningen");
        l.add("Berge (Niedersachsen)");
        l.add("Bippen");
        l.add("Essen (Oldenburg)");
        l.add("Badbergen");
        l.add("Menslage");
        l.add("Nortrup");
        l.add("Cloppenburg");
        l.add("Garrel");
        l.add("Emstek");
        l.add("Lastrup");
        l.add("Cappeln (Oldenburg)");
        l.add("Molbergen");
        l.add("Lindern (Oldenburg)");
        l.add("Meppen");
        l.add("Haren (Ems)");
        l.add("Haselünne");
        l.add("Geeste");
        l.add("Hüven");
        l.add("Spahnharrenstätte");
        l.add("Sögel");
        l.add("Werpeloh");
        l.add("Lahn (Hümmling)");
        l.add("Vrees");
        l.add("Werlte");
        l.add("Fresenburg");
        l.add("Lathen");
        l.add("Renkenberge");
        l.add("Sustrum");
        l.add("Twist (Emsland)");
        l.add("Dohren (Emsland)");
        l.add("Herzlake");
        l.add("Lähden");
        l.add("Groß Berßen");
        l.add("Klein Berßen");
        l.add("Stavern");
        l.add("Niederlangen");
        l.add("Oberlangen");
        l.add("Lingen (Ems)");
        l.add("Lingen (Ems)");
        l.add("Lingen (Ems)");
        l.add("Emlichheim");
        l.add("Laar");
        l.add("Ringe");
        l.add("Esche");
        l.add("Georgsdorf");
        l.add("Lage (Dinkel)");
        l.add("Neuenhaus");
        l.add("Osterwald");
        l.add("Andervenne");
        l.add("Beesten");
        l.add("Freren");
        l.add("Messingen");
        l.add("Thuine");
        l.add("Wietmarschen");
        l.add("Gersten");
        l.add("Handrup");
        l.add("Langen (Emsland)");
        l.add("Lengerich (Emsland)");
        l.add("Wettrup");
        l.add("Getelo");
        l.add("Gölenkamp");
        l.add("Halle bei Neuenhaus");
        l.add("Uelsen");
        l.add("Bawinkel");
        l.add("Hoogstede");
        l.add("Itterbeck");
        l.add("Wielen");
        l.add("Wilsum");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Nord");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Hamburg-Nord");
        l.add("Eimsbüttel");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Altona");
        l.add("Eimsbüttel");
        l.add("Hamburg-Mitte");
        l.add("Eimsbüttel");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Eimsbüttel");
        l.add("Altona");
        l.add("Hamburg-Mitte");
        l.add("Altona");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Bergedorf");
        l.add("Bergedorf");
        l.add("Bergedorf");
        l.add("Bergedorf");
        l.add("Bergedorf");
        l.add("Bergedorf");
        l.add("Harburg");
        l.add("Harburg");
        l.add("Harburg");
        l.add("Harburg");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Harburg");
        l.add("Harburg");
        l.add("Harburg");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Bergedorf");
        l.add("Hamburg-Mitte");
        l.add("Bergedorf");
        l.add("Hamburg-Mitte");
        l.add("Hamburg-Mitte");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Wandsbek");
        l.add("Hamburg-Nord");
        l.add("Hamburg-Nord");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Altona");
        l.add("Eimsbüttel");
        l.add("Hamburg-Nord");
        l.add("Eimsbüttel");
        l.add("Eimsbüttel");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Altona");
        l.add("Hamburg-Mitte");
        l.add("Altona");
        l.add("Hamburg-Mitte");
        l.add("Eimsbüttel");
        l.add("Altona");
        l.add("Hamburg-Mitte");
        return l;
    }


}

