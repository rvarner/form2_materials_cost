import org.openqa.selenium.chrome.ChromeDriver

driver = {
    System.setProperty('webdriver.chrome.driver', 'driver/chromedriver')
    new ChromeDriver()
}

baseNavigatorWaiting = true
atCheckWaiting = true
