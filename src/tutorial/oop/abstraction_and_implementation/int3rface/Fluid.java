package tutorial.oop.abstraction_and_implementation.int3rface;

public class Fluid {
    private final FluidType type;
    private String desc = "";
    /**
     * unit: Celsius
     */
    private int temperature = 0;

    public Fluid(FluidType type) {
        this.type = type;
    }

    public FluidType getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
