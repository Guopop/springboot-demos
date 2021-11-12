package me.guopop.demos.reflect_demo;

/**
 * @author guopop
 * @date 2020/10/16 13:46
 */
public class Hero {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
