package testOzon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class FirstTestRef {
    private WebDriver driver;


    public FirstTestRef(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void open() {
        driver.get("https://www.ozon.ru/");
    }


    @FindBy(className = "cookies-info")
    private WebElement cookies;
    private By closeWind = By.className("close");

    public void closeWind() {
        cookies.findElement(closeWind).click();
    }


    public void openCatalogMusic() {
        driver.findElement(By.className("catalog-button")).click();
    }

    private By openMusic = By.cssSelector("[href=\"/category/muzyka-13100/\"]");

    public void openMusic() {
        driver.findElement(openMusic).click();
    }

    public void openVinyl() {
        driver.findElement(By.cssSelector("[href=\"/category/vinilovye-plastinki-31667/\"]")).click();
    }

    public void equalsURLVinil() {
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.ozon.ru/category/vinilovye-plastinki-31667/"));
    }

    @FindBy(className = "widget-search-result-container")
    private WebElement list;
    private By index = By.cssSelector("[data-index]");

    public int getListSize() {
        List<WebElement> fulList = list.findElements(index);
        return fulList.size();
    }

    public int getRandomIndex(int max) {
        Random rand = new Random();
        return (1 + rand.nextInt((max - 1)));
    }

    @FindBy(className = "tiles")
    private WebElement record;

    public void vinilRecordNumber(int numbeIndex) {
        record.findElement(By.cssSelector("[data-index=\"" + numbeIndex + "\"]")).click();
    }

    @FindBy(className = "panel")
    private WebElement saveName;
    private By addName = By.className("name");

    public String saveRecordName() {
        String saveVinilName = saveName.findElement(addName).getText();
        return saveVinilName;
    }


    public String saveRecordPrice() {
        String saveVinilPrice = driver.findElement(By.xpath("//div[@class=\"prices-wrap\"]//span[@class=\"main\"]")).getText();
        return saveVinilPrice;
    }

    @FindBy(className = "buttons")
    private WebElement addBas;
    private By basket = By.className("button");

    public void addBasVinil() {
        addBas.findElement(basket).click();
    }

    public void goToBas() {
        driver.findElement(By.cssSelector("[href=\"/context/cart\"]")).click();//переход в корзину
    }

    public void equalsBascetNameVinil1(String nameVinil) {
        Assert.assertEquals(driver.findElement(By.cssSelector("[data-test-id='cart-item-title']")).getText(), nameVinil);
    }

    public void equalsBascetPriceVinil1(String priceVinil) {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"wrapper m-cart m-desktop\"]//span[@class=\"price-number\"]")).getText(), priceVinil);
    }

    public void getVinilURL() {
        driver.get("https://www.ozon.ru/category/muzyka-13100/?media=26859%2C122490");
    }

    public void equalsTotalBask(String numberBooks) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.findElement(By.className("count")).getText(), numberBooks);
    }

    public List<WebElement> getListWebElements() {
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class=\"box m-box-desc\"]//a[@class=\"title\"]"));
        return elements;
    }

    public void equalsBasAndSaveNameVinil(int numberVinilBasket, String numberSaveVinil) {
        Assert.assertEquals(getListWebElements().get(numberVinilBasket).getText(), numberSaveVinil);
    }

    @FindBy(css = "[data-test-id=\"total-price-block\"]")
    private WebElement totalPrice;
    private By totalBooks = By.className("main");

    public void eqvualsTotalPrice(String savePriceVinil1, String savePriceVinil2) {
        String totalBaskPrice = totalPrice.findElement(totalBooks).getText();
        int priseVinilFerst = Integer.parseInt(savePriceVinil1.replaceAll(" ", ""));
        int priseVinilSecond = Integer.parseInt(savePriceVinil2.replaceAll(" ", ""));
        int totalVinilPrice = Integer.parseInt(totalBaskPrice.replaceAll(" ", ""));
        Assert.assertEquals(totalVinilPrice, (priseVinilFerst + priseVinilSecond));
    }

    private By delVinil = By.cssSelector("[data-test-id=\"cart-delete-selected-btn\"]");
    private By yesDelVinil = By.cssSelector("[data-test-id=\"checkcart-confirm-modal-confirm-button\"]");

    public void cleanBask() {
        driver.findElement(delVinil).click();
        driver.findElement(yesDelVinil).click();
    }

    public void equalsVinilInBasket() {
        Assert.assertEquals(driver.findElement(By.xpath("//h1[@class=\"cart-title\"]")).getText(), "Корзина пуста");
    }
}
