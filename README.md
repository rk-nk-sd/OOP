# Практические занятия

ООП - разобрать основные принципы, на примере игры.

## Задание 1

Проанализировать персонажей:

- Крестьянин
- Разбойник
- Снайпер
- Колдун
- Копейщик
- Арбалетчик
- Монах

Для каждого определить 8 полей данных(здоровьеб сила и т.п.).
3-4 поля поведения(методы атаковать, вылечить ит.д.). Создать абстрактный класс и иерархию наследников. 
Расположить классы в пакет так, чтобы в основной программе не было видно их полей.
В не абстрактных классах переопределить метод toString() так, чтобы он возвращал название класса.
Создать в основной программе по одному объекту каждого не абстрактного класса и вывести в консоли его имя.

## Задание 2

Создать две команды по 10 человек. Первая команда: крестьянин, волшебник, арбалетчик, копейщик. 
Вторая: крестьянин, снайпер, монах и вор. Каждому задать случайное имя и вывести в консоль. 
Добавить в проект класс, предназначенный для хранения координат. 
Добавить в абстрактный класс поле, экземпляр класс координат. 
Пробросить координаты через конструкторы наследников так, чтобы создавая объекты вы передавали в параметрах имя и координаты. 
Скорректировать алгоритм заполнения комманд. Кроме имён каждый персонаж должен иметь координаты. 
Одна комманда находится с левой стороны другая с правой(у=0 и у=9). 
В класс лучников добавить метод поиск ближайшего противника. Алгоритм расчёта расстояний реализовать в классе координат.

## Задание 3

Добавить в файл интерфейса метод void step() это будет основной метод взаимодействыия с объектами. 
Добавить интерфейс в базовый абстрактный класс. Реализовать этот метод во всех классах наследниках. Для начала просто заглушкой.
Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет то завершить метод. 
Есль всё да, то найти ближайшего противника и выстрелить по немы и, соответственно потратить одну стрелу. 
Реализовать весь функционал лучников в методе step().
Добавить в абстрактный класс int поле инициатива. В классах наследников инициализировать это поле. 
Крестьянин = 0, маги=1, пехота=2, лучники=3. 
В мэйне сделать так, чтобы сначала делали ход персонажи с наивысшей инициативой из обеих комманд а с наименьшей в конце.

## Задание 4

Реализовать метод step() для пихоты. Проверяем живы ли мы, ищем ближайшего противника, если противник в соседней клетке
наносим поражение. Или идет в сторону ближайшего противника. Игрок по диагонали не ходит. Перед движением проверить занята
клетка или нет (чтобы не ходить через своих и союзников).

## Задание 5

Сделать наглядный вывод **cli** после каждого шага.

## Задание 6

Реализовать метод step() для Крестьянина и Лекаря