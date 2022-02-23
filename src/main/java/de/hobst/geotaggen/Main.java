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
                    System.out.println(ort);
                    System.out.println(plz);

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
        l.add("Walldürn");
        l.add("Eberbach");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Mannheim");
        l.add("Ladenburg");
        l.add("Edingen-Neckarhausen");
        l.add("Heddesheim");
        l.add("Ilvesheim");
        l.add("Oftersheim");
        l.add("Plankstadt");
        l.add("Schwetzingen");
        l.add("Waghäusel");
        l.add("Hockenheim");
        l.add("Ketsch");
        l.add("Brühl (Baden)");
        l.add("Sankt Leon-Rot");
        l.add("Oberhausen-Rheinhausen");
        l.add("Reilingen");
        l.add("Altlußheim");
        l.add("Neulußheim");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Heidelberg");
        l.add("Neckargemünd");
        l.add("Wiesloch");
        l.add("Leimen (Baden)");
        l.add("Walldorf (Baden)");
        l.add("Schriesheim");
        l.add("Sandhausen");
        l.add("Eppelheim");
        l.add("Dossenheim");
        l.add("Nußloch");
        l.add("Rauenberg");
        l.add("Dielheim");
        l.add("Mühlhausen (Kraichgau)");
        l.add("Bammental");
        l.add("Schönau (Odenwald)");
        l.add("Gaiberg");
        l.add("Heiligkreuzsteinach");
        l.add("Malsch bei Wiesloch");
        l.add("Mauer (Baden)");
        l.add("Wiesenbach (Baden)");
        l.add("Wilhelmsfeld");
        l.add("Eberbach");
        l.add("Mudau");
        l.add("Eberbach");
        l.add("Waldbrunn (Odenwald)");
        l.add("Eberbach");
        l.add("Heddesbach");
        l.add("Schönbrunn (Baden)");
        l.add("Neckargerach");
        l.add("Zwingenberg (Baden)");
        l.add("Weinheim (Bergstraße)");
        l.add("Hirschberg an der Bergstraße");
        l.add("Hemsbach (Bergstraße)");
        l.add("Laudenbach (Bergstraße)");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Stuttgart");
        l.add("Fellbach");
        l.add("Fellbach");
        l.add("Leinfelden-Echterdingen");
        l.add("Filderstadt");
        l.add("Kornwestheim");
        l.add("Korntal-Münchingen");
        l.add("Gerlingen");
        l.add("Böblingen");
        l.add("Böblingen");
        l.add("Sindelfingen");
        l.add("Sindelfingen");
        l.add("Sindelfingen");
        l.add("Sindelfingen");
        l.add("Herrenberg");
        l.add("Holzgerlingen");
        l.add("Weil im Schönbuch");
        l.add("Schönaich");
        l.add("Magstadt");
        l.add("Filderstadt");
        l.add("Waldenbuch");
        l.add("Gärtringen");
        l.add("Grafenau (Württemberg)");
        l.add("Gäufelden");
        l.add("Jettingen");
        l.add("Aidlingen");
        l.add("Ehningen");
        l.add("Steinenbronn");
        l.add("Bondorf");
        l.add("Nufringen");
        l.add("Altdorf (Kreis Böblingen)");
        l.add("Hildrizhausen");
        l.add("Mötzingen");
        l.add("Leonberg (Württemberg)");
        l.add("Ditzingen");
        l.add("Weil der Stadt");
        l.add("Renningen");
        l.add("Rutesheim");
        l.add("Hemmingen (Württemberg)");
        l.add("Weissach");
        l.add("Friolzheim");
        l.add("Heimsheim");
        l.add("Mönsheim");
        l.add("Wimsheim");
        l.add("Waiblingen");
        l.add("Waiblingen");
        l.add("Waiblingen");
        l.add("Winnenden");
        l.add("Weinstadt");
        l.add("Kernen im Remstal");
        l.add("Leutenbach (Württemberg)");
        l.add("Korb");
        l.add("Schwaikheim");
        l.add("Backnang");
        l.add("Murrhardt");
        l.add("Wüstenrot");
        l.add("Beilstein (Württemberg)");
        l.add("Aspach bei Backnang");
        l.add("Auenwald");
        l.add("Weissach im Tal");
        l.add("Sulzbach an der Murr");
        l.add("Oppenweiler");
        l.add("Affalterbach");
        l.add("Althütte");
        l.add("Oppenweiler");
        l.add("Allmersbach im Tal");
        l.add("Burgstetten");
        l.add("Großerlach");
        l.add("Spiegelberg");
        l.add("Ludwigsburg");
        l.add("Ludwigsburg");
        l.add("Ludwigsburg");
        l.add("Ludwigsburg");
        l.add("Ludwigsburg");
        l.add("Vaihingen an der Enz");
        l.add("Ludwigsburg");
        l.add("Marbach am Neckar");
        l.add("Asperg");
        l.add("Remseck am Neckar");
        l.add("Freiberg am Neckar");
        l.add("Möglingen");
        l.add("Schwieberdingen");
        l.add("Schwieberdingen");
        l.add("Markgröningen");
        l.add("Marbach am Neckar");
        l.add("Murr");
        l.add("Steinheim an der Murr");
        l.add("Beilstein (Württemberg)");
        l.add("Oberstenfeld");
        l.add("Großbottwar");
        l.add("Benningen am Neckar");
        l.add("Erdmannhausen");
        l.add("Tamm");
        l.add("Eberdingen");
        l.add("Kirchberg an der Murr");
        l.add("Oberriexingen");
        l.add("Tübingen");
        l.add("Tübingen");
        l.add("Tübingen");
        l.add("Tübingen");
        l.add("Rottenburg am Neckar");
        l.add("Mössingen");
        l.add("Ammerbuch");
        l.add("Pliezhausen");
        l.add("Kusterdingen");
        l.add("Ofterdingen");
        l.add("Dettenhausen");
        l.add("Kusterdingen");
        l.add("Kirchentellinsfurt");
        l.add("Walddorfhäslach");
        l.add("Dußlingen");
        l.add("Hirrlingen");
        l.add("Nehren (Württemberg)");
        l.add("Neustetten");
        l.add("Horb am Neckar");
        l.add("Sulz am Neckar");
        l.add("Dornhan");
        l.add("Waldachtal");
        l.add("Starzach");
        l.add("Eutingen im Gäu");
        l.add("Empfingen");
        l.add("Vöhringen (Württemberg)");
        l.add("Nagold");
        l.add("Altensteig");
        l.add("Wildberg (Schwarzwald)");
        l.add("Haiterbach");
        l.add("Ebhausen");
        l.add("Simmersfeld");
        l.add("Egenhausen");
        l.add("Rohrdorf (Kreis Calw)");
        l.add("Freudenstadt");
        l.add("Bad Peterstal-Griesbach");
        l.add("Baiersbronn");
        l.add("Alpirsbach");
        l.add("Dornstetten");
        l.add("Pfalzgrafenweiler");
        l.add("Loßburg");
        l.add("Glatten");
        l.add("Grömbach");
        l.add("Schopfloch (Schwarzwald)");
        l.add("Grömbach");
        l.add("Seewald");
        l.add("Wörnersberg");
        l.add("Balingen");
        l.add("Rosenfeld");
        l.add("Geislingen (Zollernalbkreis)");
        l.add("Schömberg (Zollernalbkreis)");
        l.add("Dautmergen");
        l.add("Dormettingen");
        l.add("Dotternhausen");
        l.add("Hausen am Tann");
        l.add("Nusplingen");
        l.add("Obernheim");
        l.add("Ratshausen");
        l.add("Weilen unter den Rinnen");
        l.add("Zimmern unter der Burg");
        l.add("Hechingen");
        l.add("Burladingen");
        l.add("Haigerloch");
        l.add("Bisingen");
        l.add("Bodelshausen");
        l.add("Rangendingen");
        l.add("Grosselfingen");
        l.add("Jungingen");
        l.add("Neufra");
        l.add("Albstadt");
        l.add("Albstadt");
        l.add("Albstadt");
        l.add("Meßstetten");
        l.add("Winterlingen");
        l.add("Bitz");
        l.add("Schwenningen (Heuberg)");
        l.add("Straßberg");
        l.add("Sigmaringen");
        return l;
    }


}

