/*1. Создать папку на яндекс диске
2. Внутри созданной папки создать файл
3. Удалить созданный файл
4. Удалть созданную папку */
package YandexDiskApi;

import org.testng.annotations.Test;

public class Task2 {
    @Test
    public static void task2 () {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.makeFile1();
        restApiManager.deleteFile1();
        restApiManager.deleteFolder();
    }

}
