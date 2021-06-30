package YandexDiskApi;
/*1. Создать папку на яндекс диске
2. Внутри созданной папки создать файл
3. Поместить созданный файл в корзину
4. Восстановить созданный файл из корзины
5. Удалить файл и папку
*/

import org.testng.annotations.Test;

public class Task3 {
    @Test
    public static void task3() {
        RestApiManager restApiManager = new RestApiManager();
        restApiManager.createFolder();
        restApiManager.makeFile1();
        restApiManager.deleteFile1();
        restApiManager.trashRestore();//фейлится, потому что новый удаленный файд со своим id
        restApiManager.deleteFolder();
    }

}