#language:ru
@test

Функционал: Тестирование сервиса PetStore
  - Создание нового заказа POST запросом с телом из json файла, значения которого заполняем сгенерированным значениями
  - После создания нового заказа, GET запросом запрашиваем данного юзера и проверяем, что его данные соответствуют данным из тела запроса

  Сценарий: Создание заказ и удалить его.

    * сгенерировать переменные
      | id         | DD                |
      | petId      | DD                |
      | quantity   | D                 |
      | shipDate   | 2021-11-22T20:12:32.115+0000 |
      | status     | approved          |
      | complete   | true              |

    # Создаем заказ
    * создать запрос
      | method | path         | body             |
      | POST   | /store/order | createOrder.json |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | orderId | $.id |
    * сравнить значения
      | ${orderId} | != | null |

    # Вторая часть теста - запрос заказа и проверка его данных
    * создать запрос
      | method | path                    |
      | GET    | /store/order/${orderId} |
    * добавить header
      | accept | application/json        |

    # FLAKY - Из-за особенностей сервиса PetStore может возвращать 404
    * подождать 20 сек
    * отправить запрос
    * статус код 200
    * извлечь данные
      | resp_orderId | $.id       |
      | resp_shipDate| $.shipDate |

    * сравнить значения
      | ${id}       | == | ${resp_orderId}  |
      | ${shipDate} | == | ${resp_shipDate} |

    # Третья часть теста - удаление заказа
    * подождать 10 сек
    * создать запрос
      | method    | path                    |
      | DELETE    | /store/order/${orderId} |
    * добавить header
      | accept    | application/json        |

    * отправить запрос
    * статус код 200

    # Четвертая часть теста - проверка, что такого заказа больше нет
    * подождать 25 сек
    * создать запрос
      | method | path                    |
      | GET    | /store/order/${orderId} |
    * добавить header
      | accept | application/json        |
    * отправить запрос
    * статус код 404
