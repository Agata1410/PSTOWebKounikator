import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/index.html')

for (def row = 1; row <= 5; row++) {
    WebUI.setText(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_userLogin'), 'ewelina1')

    WebUI.setEncryptedText(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_passwordLogin'), String.valueOf(
            row))

    WebUI.click(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_login'))

    WebUI.waitForAlert(2)

    alert_text = WebUI.getAlertText()

    WebUI.verifyEqual(alert_text, 'Podano błędną nazwę użytkownika lub hasło!')
}

WebUI.setText(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_userLogin'), 'Ewelina1')

WebUI.setEncryptedText(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_passwordLogin'), 'aeHFOx8jV/A=')

WebUI.click(findTestObject('logowanie_edycja_Page_PSTO webMessenger/input_Zarejestruj konto_login'))

podswietlona_historia_rozmow = WebUI.getCSSValue(findTestObject('logowanie_edycja_Page_PSTO webMessenger - Zalogowano/img_Zarejestruj konto_chat'), 
    'opacity')

WebUI.verifyMatch(podswietlona_historia_rozmow, '1', true)

WebUI.closeBrowser()

