/*1. Создать папку test
2. Внутри test создать папку foo
3. Внутри foo создать файл autotest
4. Поместить test в корзину
5. Очистить корзину
6. Проверить, что корзина очищена и папоу и файлов нет
*/

package YandexDiskApi;

import org.testng.annotations.Test;


public class Task7 {
    @Test
    public static void task7() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.createFolderInFolder();
        restApiManager.createFileInFolder();
        restApiManager.deleteFolder();
        restApiManager.cleanTrash();
        restApiManager.getCleanTrash();
    }
}
