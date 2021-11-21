#language: ru
@avito
Функционал: Поиск на авито

  Сценарий: Найдем самые дорогие принтеры на авито

    Пусть открыт url "https://www.avito.ru/"
    Когда инициализация страницы "Страница авито"
    И в выпадающем "список категорий" выбрана оргтехника
    И в "поле поиска" введено значение "принтер"
    Тогда кликнуть по выпадающему "список регионов"
    Тогда в поле "региона" введено значение "Владивосток"
    И подождать 2 секунд
    И нажата кнопка "показать объявления"
    Когда инициализация страницы "Авито результат поиска"
    Тогда открылась страница результаты по запросу "Принтер"
    И активирован "чекбокс" только с фотографией
    И в выпадающем "список сортировка" выбрано значение Дороже
    И в консоль выведено значение названий и цен 3 первых товаров

