/*1. Создать папку test
2. Внутри test создать папку foo
3. Внутри foo создать файл autotest
4. Поместить test в корзину
5. Очистить корзину
6. Проверить, что корзина очищена и папоу и файлов нет
*/

package YandexDiskApi;

import org.testng.annotations.Test;

public class Task6 {
    @Test
    public static void task6() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.createFolderInFolder();
        restApiManager.createFileInFolder();
        restApiManager.deleteFolderWithFiles();
        restApiManager.cleanTrashIfNotEmpty();
        restApiManager.getTrashCleanInfo();
        restApiManager.getCleanTrash();
    }
}
