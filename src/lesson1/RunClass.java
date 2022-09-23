package lesson1;

public class RunClass {
    public static void main(String[] args) {
        Course c = new Course(1500, 50,1.5); // Создаем полосу препятствий
        System.out.println(c); // вывод информации о полосе препятствия
        TeamMember[] members = new TeamMember[4]; // массив из четырех участников
        members[0] = new TeamMember("Ivan", 1000, 50,1.3);
        members[1] = new TeamMember("Petr", 1500, 25,1.5);
        members[2] = new TeamMember("Andrey", 2000, 75,1.8);
        members[3] = new TeamMember("Sergey", 2500, 100,2.1);
        Team team = new Team("'Russian Boys'", members); // Создаем команду
        System.out.println(team); // вывод информации обо всех членах команды
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}

