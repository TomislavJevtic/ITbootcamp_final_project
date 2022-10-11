package itbootcampFinalProject.pages;

import com.github.javafaker.Faker;

public class FakerInputs {
    Faker faker = new com.github.javafaker.Faker();
    private String nameF = faker.name().firstName();
    private String phoneF = faker.number().digits(6);
    private String cityF = faker.address().city();
    private String countryF = faker.address().country();
    private String twitterF = faker.bothify("https://???????.com");
    private String gitHubF = faker.bothify("https://???????.com");

    public com.github.javafaker.Faker getFaker() {
        return faker;
    }

    public String getNameF() {
        return nameF;
    }

    public String getPhoneF() {
        return phoneF;
    }

    public String getCityF() {
        return cityF;
    }

    public String getCountryF() {
        return countryF;
    }

    public String getTwitterF() {
        return twitterF;
    }

    public String getGitHubF() {
        return gitHubF;
    }
}
