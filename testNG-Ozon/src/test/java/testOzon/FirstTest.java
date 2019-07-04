package testOzon;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FirstTest extends WebDriver {

    @Test
    public void test1() {
        FirstTestRef test = PageFactory.initElements(driver, FirstTestRef.class);
        /**
         * 1. Открытие в браузере сайта https://www.ozon.ru/.
         */
        test.open();

        /**
         * 2. Закрытие всплывающего окна.
         */
        test.closeWind();

        /**
         * 3. В меню "Все разделы" выбираем категорию "Музыка"
         */
        test.openCatalogMusic();
        test.openMusic();

        /**
         * 4. Переходим на страницу "Виниловые пластинки"
         */
        test.openVinyl();

        /**
         * 5. Проверяем, что открылся список товаров
         */
        test.equalsURLVinil();

        /**
         * 6. Получаем количество товаров на странице
         */
        test.getListSize();

        /**
         * 7. Генерируем случайное число в диапазоне от 1 до количества товаров
         */
        test.getRandomIndex(test.getListSize());

        /**
         * 8. Переходим на страницу товара
         */
        test.vinilRecordNumber(test.getRandomIndex(test.getListSize()));

        /**
         * 9. Сохраняем стоимость и название данного товара
         */
        String saveNameVinil1 = test.saveRecordName();
        String savePriceVinil1 = test.saveRecordPrice();

        /**
         * 10. Добавляем товар в корзину
         */
        test.addBasVinil();

        /**
         * 11. Проверяем то, что в корзине появился добавленный товар.
         * Переходим в корзину.
         * Сравниваем название и стоимость товара в корзине со значениями из пункта 9.
         */
        test.goToBas();
        test.equalsBascetNameVinil1(saveNameVinil1);
        test.equalsBascetPriceVinil1(savePriceVinil1);

        /**
         * 12. Возврат на страницу "Виниловые пластинки"
         */
        test.getVinilURL();

        /**
         * 13. Генерируем случайное число в диапазоне от 1 до количества товаров
         */
        test.getRandomIndex(test.getListSize());

        /**
         * 14. Переходим на страницу товара
         */
        test.vinilRecordNumber(test.getRandomIndex(test.getListSize()));

        /**
         * 15. Сохраняем стоимость и название второго товара
         */
        String saveNameVinil2 = test.saveRecordName();
        String savePriceVinil2 = test.saveRecordPrice();

        /**
         * 16. Добавляем товар в корзину
         */
        test.addBasVinil();

        /**
         * 17. Проверяем, что в корзине два товара
         */
        test.equalsTotalBask("2");

        /**
         * 18. Открываем корзину
         */
        test.goToBas();

        /**
         * 19. Проверяем, что в корзине раннее выбранные товары.
         * Получаем список добавленных товаровю
         * Сравниваем название ранее сохраненных товаров с названиями товаров в корзине.
         * Проверяем,что итоговая стоимость по двум товарам рассчитана верно
         */
        test.getListWebElements();
        test.equalsBasAndSaveNameVinil(1, saveNameVinil1);
        test.equalsBasAndSaveNameVinil(0, saveNameVinil2);
        test.eqvualsTotalPrice(savePriceVinil1, savePriceVinil2);

        /**
         * 20. Удаляем из корзины все товары
         */
        test.cleanBask();

        /**
         * 21. Проверяем, что корзина пуста
         */
        test.equalsVinilInBasket();
    }
}
