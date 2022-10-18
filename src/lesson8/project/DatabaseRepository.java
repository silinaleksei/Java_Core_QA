package lesson8.project;



import lesson8.project.entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;

// ����������� ��� ������
public interface DatabaseRepository {

    void saveWeatherData(WeatherData weatherData) throws SQLException;

    void getAllSavedData() throws IOException, SQLException;
}
