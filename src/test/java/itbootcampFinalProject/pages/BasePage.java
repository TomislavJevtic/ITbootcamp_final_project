package itbootcampFinalProject.pages;
/*
Zadatak:
Kreirati repozitorijum na github-u pod nazivom itbootcamp_final_project. Projekat mora da ima komitove nakon svake
završene celine, ne samo na kraju.

Podesite projekat tako da u isti dodate validnu verziju chromedriver-a, a takođe dodati i testNG i selenium
biblioteke u pom.xml.
Prilikom izrade projekta, potrebno je jasno odvojiti pakete za stranice i testove. Primer:
•	pages - gde cuvate sve klase koje su page-evi
•	tests - gde cuvate sve klase koje su testovi

Preporuka je da sav kod i poruke komitova budu na engleskom.

Obavezno korišćenje wait-era koji će čekati otvaranje dijaloga ili slična učitavanja.

Osnovna klasa koju svaki test da nasledjuje. Ova klasa treba da ima:
•	baseUrl - url stranice https://vue-demo.daniel-avellaneda.com
•	beforeClass - gde se podesava drajver sa implicitnim cekanjem i cekanjem za ucitavanje stranice i kreiraju svi pagevi potrebni za testiranje
•	aftterClass - gde se gasi stranica
•	beforeMethod - gde se pre svakog testa ucitava baseUrl stranica

Navedene su samo obavezne assertacije, po potrebi dodajte dodatne.

Testove podeliti po klasama:
Login Tests

 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public BasePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }
}
