package YandexDiskApi;

import org.testng.annotations.Test;

public class Task1 {
    @Test
    public static void folder() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.deleteFolder();
        restApiManager.getFolder();
    }
}
