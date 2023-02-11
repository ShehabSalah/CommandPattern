package receivers;

public class Light {
    public static final int ON = 100;
    public static final int MEDIUM = 50;
    public static final int LOW = 25;
    public static final int OFF = 0;
    String location;
    int level;

    public Light(String location) {
        this.location = location;
    }

    public void on() {
        level = ON;
        System.out.println(location + " light is on");
    }

    public void off() {
        level = OFF;
        System.out.println(location + " light is off");
    }

    public void dim(int level) {
        this.level = level;
        if (level == OFF) {
            off();
        } else {
            System.out.println(location + " light is dimmed to " + level + "%");
        }
    }

    public int getLevel() {
        return level;
    }
}
