Проект по теме: Hibernate (2)

Сегодня наша задача – выполнить второй проект по теме Hibernate. Его суть – разобраться в структуре БД, сделать маппинг энтити на существующие таблицы, и добавить минимальный функционал для проверки что маппинг выполнен правильно. Теперь подробнее:

Скачать дамп-файл (https://javarush.com/downloads/ide/javarush/dump-hibernate-2.sql) и развернуть его у себя на локальной машине. В качестве БД мы будем использовать тестовую БД, которая распространяется в качестве примера вместе с установочным пакетом MySQL. Дамп нужен для того, чтоб зафиксировать состояние БД, т. к. мы не можем гарантировать, что она не изменится через день-месяц-год.
Темплита проекта у нас не будет, поэтому проект создавай самостоятельно. Это должен быть maven проект со всеми необходимыми зависимостями (hibernate-core-jakarta, mysql-connector-java, p6spy).
Подключи в Идее нашу локальную развернутую БД как datasource. После этого во вкладке Database поставь курсор на схему movie и нажми комбинацию клавиш Alt+Ctrl+Shift+U (работает только в Ultimate версии). Это покажет структуру всей схемы movie (с названием колонок, ключами и т .). Выглядит примерно так:
https://cdn.javarush.com/images/article/2b71a9bb-4d0b-4693-81fb-b1119978a0e3/1024.webp

Согласен, смотреть не очень удобно. Отключи показ названия всех колонок и комментариев. В результате получишь схему БД, которую уже можно анализировать:

https://cdn.javarush.com/images/article/85a773a5-42a9-4cb9-b885-f05e859df442/1024.webp

Схема выглядит сложно, но не все так плохо. Для анализа структуры БД нужно найти с чего начать. Единого правильного ответа нет, но я б рекомендовал начать с таблицы film. Давай рассмотрим несколько взаимосвязей в качестве примера:
Связь между таблицами film и film_text – это явная связь OneToOne, потому что в таблице film_text есть поле film_id, которое НЕ ссылается на ID из таблицы film (нет foreign key). Но по названию и логике, эта связь должна быть. Кроме того, в таблице film_text поле film_id выступает первичным ключом, что гарантирует что одному «фильму» соответствует не более чем один «текст фильма».
Теперь давай посмотрим на таблицы film и category. С точки зрения логики, у фильма может быть несколько категорий. И одна категория, может быть, у разных фильмов. Кроме этого, между этими двумя таблицами есть промежуточная таблица связи film_category. Исходя из всего вышеперечисленного – это явная связь ManyToMany.
Смотрим на таблицы film и language. С точки зрения логики, у фильма, может быть, перевод на разные языки и разные фильмы могут быть на одном языке. То есть, напрашивается ManyToMany. Но если посмотреть на содержимое таблицы film, мы можем заметить, что каждая строка таблицы – это уникальный фильм. И в строке есть только одно поле language_id (Есть еще original_language_id, но во всех записях оно null, поэтому можем пренебречь им). То есть, у одного фильма может быть только один язык. И один язык, может быть, у разных фильмов. Связь – ManyToOne (связь направлена от film к language).
Теперь основное задание – нужно создать все необходимые энтити классы и замапить их на таблицы схемы movie.
Добавить метод, который умеет создавать нового покупателя (таблица customer) со всеми зависимыми полями. Не забудь сделать чтоб метод был транзакционным (чтоб не попасть в ситуацию что адрес покупателя записали в БД, а самого покупателя – нет).
Добавить транзакционный метод, который описывает событие «покупатель пошел и вернул ранее арендованный фильм». Покупателя и событие аренды выбери любое на свое усмотрение. Рейтинг фильма пересчитывать не нужно.
Добавить транзакционный метод, который описывает событие «покупатель сходил в магазин (store) и арендовал (rental) там инвентарь (inventory). При этом он сделал оплату (payment) у продавца (staff)». Фильм (через инвентарь) выбери на свое усмотрение. Единственное ограничение – фильм должен быть доступен для аренды. То есть либо в rental не должно быть вообще записей по инвентарю, либо должна быть заполнена колонка return_date таблицы rental для последней аренды этого инвентаря.
Добавить транзакционный метод, который описывает событие «сняли новый фильм, и он стал доступен для аренды». Фильм, язык, актеров, категории и т д выбери на свое усмотрение.
Структуру таблиц менять нельзя. Но внести свои предложения по улучшению – нужно. Одно проблемное место мы выявили в п.4 (отсутствие foreign key в таблице film_text на поле film_id таблицы film). Посмотри, есть ли еще в структуре БД такие «ляпы». Если да – добавь readme файл в корень проекта и опиши эти ляпы.