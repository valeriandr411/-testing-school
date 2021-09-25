package model;

import java.util.Objects;

/**
 * Класс, реализующий котика со свойствами <b>name</b>, <b>prettiness</b>,
 * <b>weight</b>, <b>meow</b>, <b>energy</b>.
 *
 * @version 1.0
 * @autor Pohilenco Valeria
 */
public class Kotik {
    private static int countKotiks = 0;
    private final int ENERGY_STEP = 5;

    private String name;
    private int prettiness;
    private int weight;
    private String meow;
    private int energy;

    public Kotik() {
        setKotik(100, "Tom", 2300, "mew-mew");
        countKotiks++;
    }

    public Kotik(int prettiness, String name, int weight, String meow) {
        setKotik(prettiness, name, weight, meow);
        countKotiks++;
    }

    public void setKotik(int prettiness, String name, int weight, String meow) {
        this.name = name;
        this.prettiness = prettiness;
        this.meow = meow;
        this.weight = weight;
        this.energy = 10;
    }

    public static int getCountKotiks() {return countKotiks;}

    public String getName() {return name;}

    public int getPrettiness() {return prettiness;}

    public int getWeight() {return weight;}

    public String getMeow() {return meow;}

    public void setEnergy(int energy) {this.energy += energy;}

    public void eat() {eat(ENERGY_STEP, Food.MOUSE);}

    public void eat(int energy) {eat(energy, Food.FISH);}

    public void eat(int energy, Food food) {
        this.energy += energy;
        System.out.println("Котик повысил свою энергию на " + energy + "; его пищей было: " + food.getKind());
    }

    public boolean sleep() {return changeEnergy();}

    public boolean play() { return changeEnergy();}

    public boolean chaseMouse() {return changeEnergy();}

    public boolean jump() { return changeEnergy();}

    public boolean wash() { return changeEnergy();}

    public void liveAnotherDay() {
        for (int i = 0; i < 24; i++) {
            int randomValue;
            randomValue = (int) (Math.random() * 5);
            Action action = Action.values()[randomValue];
            System.out.println("action = " + action);

            switch (action) {
                case CHASE_MOUSE:
                    if (!chaseMouse()) {
                        eat(ENERGY_STEP, Food.FOWL);
                    }
                    break;
                case SLEEP:
                    if (!sleep()) {
                        eat();
                    }
                    break;
                case PLAY:
                    if (!play()) {
                        eat(ENERGY_STEP);
                    }
                    break;
                case JUMP:
                    if (!jump()) {
                        eat(ENERGY_STEP, Food.PORK);
                    }
                    break;
                case WASH:
                    if (!wash()) {
                        eat(ENERGY_STEP, Food.GRASS);
                    }
                    break;
            }
        }
    }

    private boolean isEnergetic() {return energy > 0;}

    private boolean changeEnergy() {
        if (isEnergetic()) {
            energy -= ENERGY_STEP;
            return true;
        } else {
            System.out.println("Я голоден, мои энергетические запасы равны: "
                    + energy + ". Я отказываюсь что-либо делать. Покорми меня");
            return false;
        }
    }

    private enum Action {
        CHASE_MOUSE(0),
        SLEEP(1),
        PLAY(2),
        JUMP(3),
        WASH(4);

        private final int state;

        Action(int state) {
            this.state = state;
        }
    }

    private enum Food {
        FOWL("fowl"),
        MOUSE("mouse"),
        PORK("pork"),
        FISH("fish"),
        GRASS("grass");

        private final String kind;

        Food(String kind) {
            this.kind = kind;
        }

        public String getKind() {
            return kind;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kotik kotik = (Kotik) o;
        return Objects.equals(meow, kotik.meow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meow);
    }
}
