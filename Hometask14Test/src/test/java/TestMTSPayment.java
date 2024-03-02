import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMTSPayment extends TestMTS {
    @Test
    public void payConnection() {
        WebElement selectService = driver.findElement(By.xpath("//button[@class='select__header']"));
        selectService.click();
        WebElement payConnection = driver.findElement(By.xpath("//li[1]/p[text()='Услуги связи']"));
        payConnection.click();
        WebElement inputNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        inputNumber.click();
        inputNumber.sendKeys("297777777");
        WebElement inputSum = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        inputSum.click();
        inputSum.sendKeys("50");
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='connection-email']"));
        inputEmail.click();
        inputEmail.sendKeys("help_me@please.by");
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]"));
        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 50);
        //переключаем на фрейм и проверяем сумму
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement elementContentSum = driver.findElement(By.xpath(".//div[@class='header__payment-amount']"));
        int sum=50;
        Assertions.assertEquals(sum+".00",elementContentSum.getAttribute("textContent").replace("BYN","").trim());
        //проверяем сумму на кнопке "Оплатить"
        WebElement elementContentSumButton = driver.findElement(By.xpath(".//button[@class='colored disabled ng-star-inserted']"));
        Assertions.assertEquals("Оплатить  "+sum+".00", elementContentSumButton.getAttribute("textContent").replace("BYN","").trim());
        //проверяем номер телефона
        WebElement elementContentPhone = driver.findElement(By.xpath("//p[@class='header__payment-info']"));
        String phoneNumber=String.valueOf(297777777);
        Assertions.assertEquals(phoneNumber,elementContentPhone.getAttribute("textContent").replace("Оплата: Услуги связи\nНомер: 375","").trim());
        /*WebElement inscriptionPayCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-1 ng-star-inserted']"));
        String inscriptionCard = inscriptionPayCard.getText();
        System.out.println("Надпись в незаполненном поле для ввода номера карты: " + inscriptionCard);
        WebElement inscriptionTermPayCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-4 ng-star-inserted']"));
        String inscriptionTerm = inscriptionTermPayCard.getText();
        System.out.println("Надпись в незаполненном поле для ввода срока действия карты: " + inscriptionTerm);
        WebElement inscriptionCodePayCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-5 ng-star-inserted']"));
        String inscriptionCode = inscriptionCodePayCard.getText();
        System.out.println("Надпись в незаполненном поле для ввода CVV кода карты: " + inscriptionCode);
        WebElement inscriptionNameHolderPayCard = driver.findElement(By.xpath("//label[@class='ng-tns-c47-3 ng-star-inserted']"));
        String inscriptionName = inscriptionNameHolderPayCard.getText();
        System.out.println("Надпись в незаполненном поле для ввода имени владельца карты: " + inscriptionName);
        WebElement logoVisa = driver.findElement
                (By.xpath("//img[contains(text(),'visa-system']"));
        assertTrue(logoVisa.isDisplayed(), "Логотип не отображается");
        WebElement logoMaster = driver.findElement
                (By.xpath("//img[contains(text(),'mastercard-system']"));
        assertTrue(logoMaster.isDisplayed(), "Логотип не отображается");
        WebElement logoBel = driver.findElement
                (By.xpath("//img[contains(text(),'belcart-system']"));
        assertTrue(logoBel.isDisplayed(), "Логотип не отображается");
        WebElement logoMir = driver.findElement
                (By.xpath("//img[contains(text(),'mir-system']"));
        assertTrue(logoMir.isDisplayed(), "Логотип не отображается");*/
        WebElement closeButton = driver.findElement(By.xpath("//div[@class='header__close-button']//svg-icon[@class='header__close-icon']"));
        closeButton.click();
    }

}




