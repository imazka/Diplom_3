package org.example;

import java.io.IOException;

public class CloseAllSeleniumDrivers {
    public static void main(String[] args) {
        closeAllDrivers();
    }

    public static void closeAllDrivers() {
        try {
            // Завершение всех процессов chromedriver
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            // Завершение всех процессов geckodriver (Firefox)
            Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}