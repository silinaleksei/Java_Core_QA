package lesson1_dz;

public class RunClass {
    public static void main(String[] args) {

        Obstacle[] obstacles = new Obstacle[3]; // массив из трёх препятствий
        obstacles[0] = new Obstacle("runTrack", 1500);
        obstacles[1] = new Obstacle("waterTrack", 50);
        obstacles[2] = new Obstacle("wall", 1.5);
        Course course = new Course("Course#1", obstacles); // Создаем полосу препятствий
        System.out.println(course); // вывод информации о полосе препятствия

        TeamMember[] members = new TeamMember[4]; // массив из четырех участников
        members[0] = new TeamMember("Ivan", 1000, 50,1.3);
        members[1] = new TeamMember("Petr", 1500, 25,1.5);
        members[2] = new TeamMember("Andrey", 2000, 75,1.8);
        members[3] = new TeamMember("Sergey", 2500, 100,2.1);
        Team team = new Team("'Russian Boys'", members); // Создаем команду
        System.out.println(team); // вывод информации обо всех членах команды
        course.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
