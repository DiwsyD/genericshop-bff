# ТЗ для курсової роботи

### 1. Проект по обраній вами темі у вигляді двох мікросервісів.

    - Мікросервіс №1: "microservice-api" - мікросервіс, що повертає в якості результата дані у вигляді json\xml
    - Мікросервіс №2: "microservice-bff" - мікросервіс, що повертає ModelAndView (гарні html сторінки) із даними із api-мікросервісу.

### 2. "Microservice-api" повинен:

1. Взаємодіяти із БД (MySQL\Mongo) для зберігання та отримання даних (об'єктів вашої доменної області) так користувачів.
2. Безперешкодно віддавати дані як користувачу (через браузер\postman) так і до microservice-bff. (GET)
3. Давати можливість взаємодіяти із собою користувачеві (через браузер\postman) так і microservice-bff. (
   POST\PUT\PATCH\DELETE)
4. Валідувати вхідні дані від користувача (браузер\postman) так і від microservice-bff. (Spring-validation)
5. Мати обробку помилок та інформативно віддавати користувачу інформацію про виникшу помилку (із усіма деталями роботи
   сервіса та де, чому і як виникла помилка)

### 3. "Microservice-bff" -

1. Взаємодіяти із microservice-api для отримання та зберігання даних.
2. Безперешкодно віддавати дані як користувачу через браузер\postman. (GET)
3. Давати можливість взаємодіяти із собою користувачеві через браузер\postman. (POST\PUT\PATCH\DELETE)
4. Валідувати вхідні дані від користувача браузер\postman. (Spring-validation)
5. Мати різні доступи до ендпоінтів в залежності від ролі користувача.
6. Віддавати в якості відповіді ModelAndView (htnl+thymeleaf сторінку із даними)
7. Мати обробку помилок та інформативно віддавати користувачу інформацію про виникшу помилку (без деталей роботи
   сервіса)

### 4. Мікросервіси, повинні взаємодіяти через Spring-Eureka

    (Окремий мікросервіс)

### 5. Front-end повинен мати:

1. Як мінімум 1 головну сторінку та 1 сторінку для взаємодії із доменною областю проекту. (Можливість зберегти та
   отримати нові дані через ui на сторінці)
2. На головній сторінці мати навігацію для можливості спробувати увесь можлиий функціонал проекту.
3. Нема критеріїв до оформлення (css\js) - це на ваш смак, головне щоб функціонал працював.

## (Проект повинен мати мінімум помилок, якщо вони є - то обробляти їх і видавати адекватну відповідь. На випадок якщо функціоналу нема - зробити сторінку яка б інформувала що функціоналу нема, але такий підхід не буде зараховано як "виконана курсова".)