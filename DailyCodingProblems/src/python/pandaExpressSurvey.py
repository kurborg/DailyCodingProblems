import selenium
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.common.service import Service

def inputSurveyCode(code, lastDigits):
    global driver 
    x = Service('/Users/kurtborgsmiller/Downloads/chromedriver')
    options = webdriver.ChromeOptions()
    options.add_experimental_option('excludeSwitches', ['enable-logging'])
    driver = webdriver.Chrome(service=x, options=options)
    driver.get("https://www.pandaguestexperience.com/")

    code4Digit = code.split(" ")
    for i in range(1,6): 
        inputBox = driver.find_element(By.NAME, "CN" + str(i))
        print(code4Digit[i-1])
        inputBox.send_keys(code4Digit[i-1])
    inputBox = driver.find_element(By.NAME, "CN6")
    print(lastDigits)
    inputBox.send_keys(lastDigits)

    try:
        link = driver.find_element(By.ID, "NextButton")
        link.click()
    except selenium.common.exceptions.NoSuchElementException:
        print("Wrong Survey Code")
        driver.quit()
    
def FillOutSurvey():
    nextLink = driver.find_elements(By.ID, "NextButton")
    while len(nextLink) != 0:
        optionButton = driver.find_elements(By.CLASS_NAME, "radioSimpleInput")
        for i in range (0, len(optionButton), 5):
            optionButton[i].click()
        nextLink = driver.find_elements(By.ID, "NextButton")
        if len(nextLink) == 0:
            break
        nextLink[0].click()

def main():
    code = input("Enter Panda Survey code separated by spaces for - : ")
    lastDigits = code[len(code) - 2 : len(code):]
    code = code[:len(code)-2:]
    inputSurveyCode(code, lastDigits)
    FillOutSurvey()

if __name__ == "__main__":
    main()