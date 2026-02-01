package edu.narxoz.galactic.demo;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.Dispatcher;
import edu.narxoz.galactic.task.Result;

public class Demo {
     public static void main(String[] args, Drone hD) {
        Planet jupiter = new Planet("Jupiter",10,0, "H2O");
        Planet mars = new Planet("Mars",100,0, "3HCL");
        Cargo cargo = new Cargo(80,"Heavy object");
        LightDrone lD = new LightDrone("LD-1", 10);
        HeavyDrone hD11 = new HeavyDrone("HD-3", 70);
        DeliveryTask task = new DeliveryTask( jupiter,mars, cargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("1. Task to LightDrone:");
        Result res1 = (Result) dispatcher.assignTask(task, lD);
        System.out.println("Result: " + res1.ok()+"reason: " + res1.reason());

        System.out.println("\n 2. Task to HeavyDrone:");
        Result res2 = (Result) dispatcher.assignTask(task, hD11);
        System.out.println("Result: " + res2.ok()+"reason: " + res2.reason());

        System.out.println("\n 3.Estimate delivery time: ");
        double time = task.estimateTime();
        System.out.println("Estimate time:" + time);

        System.out.println("\n 4. Complete task: ");
        Result res3= (Result) dispatcher.completeTask(task);
        System.out.println("Result: " + res3.ok() +"reason: " + res3.reason());

        System.out.println("\n Finals: ");
        System.out.println("Drone " + hD11.getStatus());
        System.out.println("Task " + task.getState());
    }
}
