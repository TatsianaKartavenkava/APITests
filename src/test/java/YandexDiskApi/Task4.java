/*Получить информацию и диске пользователя
1. Создать папку на яндекс диске
2. Внутри созданной папки создать несколько файлов
3. Поместить созданные файлы в корзину
//4. Посчитать количество файлов в корзине
//5. Сравнить что файлов в корзине = первоначальному количеству + количеству файлов в корзине
4. Восстановить созданный файл из корзины
5. Удалить файл и папку
*/
package YandexDiskApi;

import org.testng.annotations.Test;

public class Task4 {
    @Test
    public static void task4() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.getInfoAboutDiskUser();
        restApiManager.createFolder();
        restApiManager.makeFile1();
        restApiManager.makeFile2();
        restApiManager.countTotalInTrashEmpty();
        restApiManager.deleteFile1();
        restApiManager.deleteFile2();
        restApiManager.countTotalInTrashNotEmpty();
        restApiManager.trashRestoreFile();
        restApiManager.deleteFolderWithFiles();
        restApiManager.cleanTrashIfNotEmpty();


    }
}
