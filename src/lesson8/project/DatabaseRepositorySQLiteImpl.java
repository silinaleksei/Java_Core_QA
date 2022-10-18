package lesson8.project;


import lesson8.project.entity.WeatherData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "city TEXT NOT NULL, " +
            "date_time TEXT NOT NULL, " +
            "weather_text TEXT NOT NULL, " +
            "temperature REAL NOT NULL);";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void saveWeatherData(WeatherData weatherData) throws SQLException {
        createTableIfNotExists();
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            saveWeather.execute();
            return;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public void getAllSavedData() throws SQLException {
        List<WeatherData> weatherDataList;
        try (ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT * FROM weather")) {
            weatherDataList = new ArrayList<>();
            while (resultSet.next()) {
                weatherDataList.add(new WeatherData(resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4), resultSet.getDouble(5)));
            }
        }
        System.out.println(weatherDataList);
    }
}
