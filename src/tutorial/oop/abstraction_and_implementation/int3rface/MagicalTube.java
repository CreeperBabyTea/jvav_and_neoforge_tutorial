package tutorial.oop.abstraction_and_implementation.int3rface;

public class MagicalTube implements FluidProcessor {
    @Override
    public Fluid process(Fluid original) {
        return new Fluid(
                switch (original.getType()) {
                    case WATER -> FluidType.MOLTEN_GEMSTONE;
                    case LAVA -> FluidType.MOLTEN_MITHRIL;
                    default -> original.getType();
                }
        );
    }
}
