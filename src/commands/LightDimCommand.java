package commands;

import receivers.Light;

public class LightDimCommand implements Command {
    Light light;
    int prevDim;

    public LightDimCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        switch (light.getLevel()) {
            case Light.ON -> {
                light.dim(Light.MEDIUM);
                prevDim = Light.ON;
            }
            case Light.MEDIUM -> {
                light.dim(Light.LOW);
                prevDim = Light.MEDIUM;
            }
            case Light.LOW -> {
                light.off();
                prevDim = Light.LOW;
            }
            case Light.OFF -> System.out.println("Light is Off!");
        }
    }

    @Override
    public void undo() {
        switch (prevDim) {
            case Light.ON -> light.on();
            case Light.MEDIUM -> light.dim(Light.MEDIUM);
            case Light.LOW -> light.dim(Light.LOW);
            case Light.OFF -> light.off();
        }
    }
}
