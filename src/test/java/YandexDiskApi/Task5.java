/*1. Создать папку test
2. Внутри test создать папку foo
3. Внутри foo создать файл autotest
4. Получить метаданные test и сравнить что и тип параметров соответсвует ожидаемому
5. Удалить папку тест
6. Проверить ,что удалилась папку test, foo и файл autotest
*/
package YandexDiskApi;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Task5 {
    @Test
    public static void task5() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.createFolderInFolder();
        restApiManager.createFileInFolder();
        restApiManager.getMetaInfoFolder();
        restApiManager.deleteFolderWithFiles();
        restApiManager.getTrashInfo();
        restApiManager.cleanTrashIfNotEmpty();
    }

}
