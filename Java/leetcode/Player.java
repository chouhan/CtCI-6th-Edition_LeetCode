import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Player implements Comparable<Player> {
    private int ranking;
    private String name;
    private int age;

    public Player(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    // constructor, getters, setters

    public int getRanking() {
        return ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return ranking == player.ranking &&
                age == player.age &&
                Objects.equals(name, player.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(ranking, name, age);
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Player o) {
        return (this.getRanking() - o.getRanking());
    }

    public static void main(String[] args) {
        List<Player> footballTeam = new ArrayList<>();
        Player player1 = new Player(59, "John", 20);
        Player player2 = new Player(67, "Roger", 22);
        Player player3 = new Player(45, "Steven", 24);
        footballTeam.add(player1);
        footballTeam.add(player2);
        footballTeam.add(player3);

        // Test with Comparable interface
        System.out.println("Before Sorting : " + footballTeam);
        Collections.sort(footballTeam);
        System.out.println("After Sorting : " + footballTeam);

        // Test with Comparator interface
        System.out.println("Before Sorting Age : " + footballTeam);
        PlayerAgeComparator playerComparator = new PlayerAgeComparator();
        Collections.sort(footballTeam, playerComparator);
        System.out.println("After Sorting Age : " + footballTeam);
    }

    public static class PlayerRankingComparator implements Comparator<Player> {
        @Override
        public int compare(Player firstPlayer, Player secondPlayer) {
            return (firstPlayer.getRanking() - secondPlayer.getRanking());
        }
    }

    public static class PlayerAgeComparator implements Comparator<Player> {
        @Override
        public int compare(Player firstPlayer, Player secondPlayer) {
            return (firstPlayer.getAge() - secondPlayer.getAge());
        }
    }

    /*Comparator<Player> byRanking
            = (Player player1, Player player2) -> player1.getRanking() - player2.getRanking();*/
    Comparator<Player> byRanking = Comparator
            .comparing(Player::getRanking);

}