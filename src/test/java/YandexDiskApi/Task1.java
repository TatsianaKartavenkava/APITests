/*1. Создать папку на диске
2. Удалить созданную папку
3. Проверить, что папку удалена
Чтобы включить программу чтения с экрана, нажмите Ctrl+Alt+Z. Для просмотра списка быстрых клавиш нажмите Ctrl+косая черта.
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
