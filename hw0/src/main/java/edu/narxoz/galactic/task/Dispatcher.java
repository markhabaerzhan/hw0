package edu.narxoz.galactic.task;

import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneStatus;

public class Dispatcher {
    public Result assignTask(DeliveryTask task, Drone drone){
        if(task==null || drone==null){
            return new Result(false,"task or drone is null");
        }
        if(drone.getStatus()!=DroneStatus.IDLE){
            return new Result(false,"drone isn't IDLE");
        }
        Cargo cargo = task.getCargo();
        if(cargo.getWeightKg()> drone.getMaxPayloadKg()){
            return new Result(false,"cargo is heavy");
        }
        if(task.getState()!=TaskState.CREATED){
            return new Result(false,"task isn't in created state");
        }
        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);
        return new Result(true,"task completed");
    }
    public Result completeTask(DeliveryTask task){
        if(task==null){
            return new Result(false, "task is null");
        }
        if(task.getState()!=TaskState.ASSIGNED){
            return  new Result(false, "task isn't assigned");
        }
        Drone drone = task.getAssignedDrone();
        if(drone==null){
            return new Result(false, "no drone assigned");
        }
        if(drone.getStatus()!=DroneStatus.IN_FLIGHT){
            return new Result(false, "drone isn't in flight");
        }
        task.setState(TaskState.DONE);
        drone.setStatus(DroneStatus.IDLE);
        return new Result(true," task completed");

    }
    
}
