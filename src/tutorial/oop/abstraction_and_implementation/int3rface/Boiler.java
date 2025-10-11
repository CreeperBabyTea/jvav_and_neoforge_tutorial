package tutorial.oop.abstraction_and_implementation.int3rface;

public class Boiler implements FluidProcessor {
    private boolean broken = false;

    @Override
    public Fluid process(Fluid original) {
        if (!broken && original.getType() == FluidType.WATER) {
            System.out.println("Boiling water!");
            original.setTemperature(100);
            System.out.println("Water boiled!");
        } else {
            broken = true;
            System.out.println("Ouch! The boiler is broken due to wrong liquid type!");
        }
        return original;
    }
}
