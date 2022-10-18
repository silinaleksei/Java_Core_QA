package lesson8.project;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String DB_FILENAME = "application.db";

    private ApplicationGlobalState() {
    }

    // Ќепотокобезопасный код дл€ упрощени€
    public static ApplicationGlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }
    public String getDbFileName() {
        return DB_FILENAME;
    }
    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return "XcBpOGA0G2Lnwrhh7KCJyPnji0aml6Kj"; // my token
        //return "HBAoYTHBeloWennir9bjrNSNYgoGaCqz"; // Maksim's token
    }
}
