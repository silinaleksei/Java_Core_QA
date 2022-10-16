package lesson7.project;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;

    private ApplicationGlobalState() {
    }

    // Ќепотокобезопасный код дл€ упрощени€
    public static ApplicationGlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
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
