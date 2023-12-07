package de.goldendeveloper.geotaggen;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private final String apiKey;
    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    public Config() {
        Dotenv dotenv = Dotenv.load();
        apiKey = dotenv.get("GEO_API_KEY");
        dbUrl = dotenv.get("DB_URL");
        dbUser = dotenv.get("DB_USER");
        dbPassword = dotenv.get("DB_PASSWORD");
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
