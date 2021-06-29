package YandexDiskApi;

import org.testng.annotations.Test;

public class Task3 {
    @Test
    public static void task3() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.makeFiles();
        restApiManager.deleteFile();
        restApiManager.deleteFolder();
    }
}