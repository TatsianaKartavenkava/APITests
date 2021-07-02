/*1. Создать папку на диске
2. Удалить созданную папку
3. Проверить, что папку удалена
*/
package YandexDiskApi;

import org.testng.annotations.Test;

public class Task1 {
    @Test
    public static void task1() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.deleteFolder();
        restApiManager.getFolder();

    }
}
