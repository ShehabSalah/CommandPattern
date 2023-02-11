import commands.*;
import invoker.RemoteControl;
import receivers.Light;
import receivers.TV;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize receivers
        Light livingRoomlight = new Light("Living Room");
        TV tv = new TV();

        // initialize Light commands
        LightOnCommand lightOnCommand = new LightOnCommand(livingRoomlight);
        LightOffCommand lightOffCommand = new LightOffCommand(livingRoomlight);
        LightDimCommand lightDimCommand = new LightDimCommand(livingRoomlight);

        // initialize TV commands
        TVOnCommand tvOnCommand = new TVOnCommand(tv);
        TVOffCommand tvOffCommand = new TVOffCommand(tv);

        // initialize the remote controller
        RemoteControl remoteControl = new RemoteControl();
        // set light commands
        remoteControl.setCommand(0, lightOnCommand, lightOffCommand);
        // set dim light commands
        remoteControl.setCommand(1, new NoCommand(), lightDimCommand);
        // set tv commands
        remoteControl.setCommand(2, tvOnCommand, tvOffCommand);

        Scanner scanner = new Scanner(System.in);
        int slot = 0;
        while (slot != -1) {
            System.out.println("Press Button: ");
            System.out.println("1 => Light on");
            System.out.println("2 => Light off");
            System.out.println("3 => Light dim");
            System.out.println("4 => TV on");
            System.out.println("5 => TV off");
            System.out.println("6 => Undo");
            System.out.println("-1 => Out");
            slot = scanner.nextInt();

            switch (slot) {
                case 1 -> remoteControl.onButtonPressed(0);
                case 2 -> remoteControl.offButtonPressed(0);
                case 3 -> remoteControl.offButtonPressed(1);
                case 4 -> remoteControl.onButtonPressed(2);
                case 5 -> remoteControl.offButtonPressed(2);
                case 6 -> remoteControl.undoButtonPressed();
            }
        }
    }
}