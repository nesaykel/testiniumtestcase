package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class n11 {
    protected WebDriver driver;

    @Before
    public void setUp() throws Exception{
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HpPC\\Downloads\\TestiniumTestCase\\driver\\chromedriver.exe");
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("https://www.n11.com");
        System.out.println("Adrese ulaşıldı");
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
public void login(){
        WebElement signIn = driver.findElement(By.className("btnSignIn"));
            signIn.click();
        WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("neslihan.keles@isik.edu.tr");
    System.out.println("Email girildi");
        WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("123456789nes");
    System.out.println("Password girildi");
        WebElement loginBtn = driver.findElement(By.id("loginButton"));
            loginBtn.click();
    System.out.println("Giriş yapıldı");
}
@Test
public void search(){
        WebElement searchData = driver.findElement(By.id("searchData"));
            searchData.sendKeys("Bilgisayar");
        System.out.println("Arama yapıldı");
        WebElement searchBtn = driver.findElement(By.className("searchBtn"));
            searchBtn.click();
        System.out.println("Arama sonuçları tamamlandı");
}
@Test
public void urunEkleme(){
    Random rnd = new Random();
    int index = rnd.nextInt(28) + 1;
    WebElement search = driver.findElement(By.id("searchData"));
        search.sendKeys("Bilgisayar");
    WebElement searchBtn = driver.findElement(By.className("searchBtn"));
        searchBtn.click();
    System.out.println("Arama sonuçları tamamlandı");
        List <WebElement> urunFiyatListesi = driver.findElements(By.xpath("//*[@id=\"p-399100932\"]"));
        String fiyat = urunFiyatListesi.get(index).getText();
    List<WebElement> urunler = driver.findElements(By.className("productArea"));
    urunler.get(index).click();
    String secilenUrunFiyat = driver.findElement(By.className("priceArea")).getText();
    WebElement sepeteEkle = driver.findElement(By.className("btn btnGrey btnAddBasket"));
        sepeteEkle.click();
    System.out.println("Ürün sepete eklendi");
    WebElement sepeteGit = driver.findElement(By.className("btn btnBlack btnGoBasket"));
        sepeteGit.click();
    Assert.assertEquals("Sonuç",fiyat,secilenUrunFiyat);
    WebElement arttir = driver.findElement(By.className("spinnerUp spinnerArrow"));
        arttir.click();
    System.out.println("Ürün adedi arttırıldı");
    WebElement sil = driver.findElement(By.className("removeProd svgIcon svgIcon_trash"));
        sil.click();
    System.out.println("Ürün sepetten silindi");
}
@Test

    @After
    public void tearDown()throws Exception{
        driver.quit();
    }
}
