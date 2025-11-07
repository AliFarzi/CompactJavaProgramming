#  Task Module — Concurrent Charging Simulation

##  Overview
This module (`Homework3.TaskModule`) simulates a **concurrent AGV charging system** using Java multithreading.  
It models a scenario where multiple AGVs (Autonomous Guided Vehicles) request charging at random times while a limited number of charging stations (`K`) are available.

The concurrency is managed entirely inside this module through the **TaskManager** and **ChargingTask** classes.

---

##  Core Logic

- The **TaskManager** creates:
  - A random number of charging stations (`K`)
  - A number of AGVs (`N`) arriving randomly over time  
- Each charging station is represented as one thread in an **ExecutorService** (`FixedThreadPool` of size `K`).  
- When a new AGV appears:
  - The manager checks if the **expected waiting time** for a station is less than the configured threshold (e.g., 15 minutes).  
  - If yes → AGV is assigned, and a new **ChargingTask** starts immediately.  
  - If no → AGV leaves the queue.  

Each **ChargingTask** (`Runnable`) simulates the charging progress, updating its expected remaining time at every step.

---

##  Concurrency Behavior

| Component | Description |
|------------|--------------|
| **Executor Type** | `Executors.newFixedThreadPool(K)` |
| **Simultaneous Tasks** | Up to `K` AGVs charging at once |
| **Arrival Pattern** | Randomized AGV arrivals (0.5–1s delay) |
| **Queue Logic** | AGVs skip if waiting time > allowed limit |
| **Dynamic Update** | Charging time decreases in real time |

---

##  How It Works (Simplified Flow)

1. Create `K` random charging stations.  
2. Start a thread pool with `K` workers.  
3. Generate `N` AGVs with random battery levels.  
4. For each arriving AGV:
   - Check available station with least queue time.  
   - If station wait time < threshold → assign AGV and start `ChargingTask`.  
   - Otherwise → reject the AGV (“wait time exceeded”).  
5. Each task simulates charging in 10% steps until full.  
6. When charging completes, the task releases the station automatically.

---

##  Running the Simulation

### Steps:
1. Open the project in your IDE.  
2. Go to:  TaskManager.java file
3. Run the `main()` method.  

### Configuration:
```java
int K = 3;          // Number of charging stations
int N = 10;         // Number of AGVs to generate
double waitTime = 2 * 1000; // Max waiting time (ms) — demo value

### Example Output:

Creating and assigning AGVs to Charging Stations...10 AGVs to be created, and 3 Stations available.
Charging Station ID: CS001 No AGV, Current Queue Time (ms): 0.0
AGV001 assigned to CS001
Starting Charging Task for Equipment ID: AGV001
Equipment ID: AGV001 Expected Charging Time (ms): 4000.0
Charging Station ID: CS001 Current Queue Time (ms): 4000.0
Charging Station ID: CS002 No AGV, Current Queue Time (ms): 0.0
AGV002 assigned to CS002
Starting Charging Task for Equipment ID: AGV002
Equipment ID: AGV002 Expected Charging Time (ms): 6000.0       
Equipment ID: AGV001 Expected Charging Time (ms): 3000.0
Charging Station ID: CS001 Current Queue Time (ms): 3000.0
Charging Station ID: CS002 Current Queue Time (ms): 6000.0     
Charging Station ID: CS003 No AGV, Current Queue Time (ms): 0.0
AGV003 assigned to CS003
Starting Charging Task for Equipment ID: AGV003
Equipment ID: AGV003 Expected Charging Time (ms): 5000.0       
Equipment ID: AGV002 Expected Charging Time (ms): 5000.0
Equipment ID: AGV001 Expected Charging Time (ms): 2000.0
Charging Station ID: CS001 Current Queue Time (ms): 2000.0
Charging Station ID: CS002 Current Queue Time (ms): 5000.0
Charging Station ID: CS003 Current Queue Time (ms): 5000.0
AGV004 could not be assigned ? wait time exceeded.  
