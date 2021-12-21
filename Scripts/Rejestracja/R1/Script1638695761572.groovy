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

WebUI.navigateToUrl('http://kmg.hcm.pl/testowanie/index.html')

for (def row = 1; row <= findTestData('Rejestracja/tabR1').getRowNumbers(); row++) {
    data = new Date().getTime()

    username = ('Ameba' + data)

    WebUI.click(findTestObject('Page_PSTO webMessenger/a_Zarejestruj konto'))

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_username'), username)

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_pass1'), findTestData(
            'Rejestracja/tabR1').getValue('password', row))

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_pass2'), findTestData(
            'Rejestracja/tabR1').getValue('password2', row))

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_name'), findTestData(
            'Rejestracja/tabR1').getValue('name', row))

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_surname'), findTestData(
            'Rejestracja/tabR1').getValue('surname', row))

    WebUI.setText(findTestObject('Object Repository/Page_PSTO webMessenger/input_Powrt do logowania_kodgrupy'), findTestData(
            'Rejestracja/tabR1').getValue('group', row))

    WebUI.click(findTestObject('Page_PSTO webMessenger/input_Powrt do logowania_register'))

    WebUI.click(findTestObject('Page_PSTO webMessenger/a_Kliknij, aby si zalogowa'))

    WebUI.setText(findTestObject('Page_PSTO webMessenger/input_Zarejestruj konto_userLogin'), username)

    WebUI.setText(findTestObject('Page_PSTO webMessenger/input_Zarejestruj konto_passwordLogin'), findTestData('Rejestracja/tabR1').getValue(
            'password', row))

    WebUI.click(findTestObject('Page_PSTO webMessenger/input_Zarejestruj konto_login'))

    WebUI.click(findTestObject('Page_PSTO webMessenger - Zalogowano/img_Zarejestruj konto_iconImg'))
}

WebUI.closeBrowser()

