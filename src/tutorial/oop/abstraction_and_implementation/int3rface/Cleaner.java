package tutorial.oop.abstraction_and_implementation.int3rface;

public class Cleaner implements FluidProcessor {
    @Override
    public Fluid process(Fluid original) {
        var oldDesc = original.getDesc();
        if (oldDesc.contains("dirty"))
            original.setDesc(oldDesc.replace("dirty", ""));
        return original;
    }
}
