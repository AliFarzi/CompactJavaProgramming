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
```

## Answering Questions

This section provides an overview and comparison of **concurrency models**, including **Concurrency vs. Parallelism** and the differences between **Blocking** and **Non-blocking algorithms** used in concurrent systems.

---

###  Concurrency vs Parallelism

| Concept | Description | Example | Purpose |
|----------|--------------|----------|----------|
| **Concurrency** | The ability of a system to handle multiple tasks *at once* conceptually. Tasks start, run, and complete in overlapping time periods. | Multiple AGVs waiting and taking turns to use charging stations — even if one thread handles them via switching. | Manage multiple tasks efficiently. |
| **Parallelism** | Actual simultaneous execution of tasks on multiple CPU cores or threads. | Each charging station has its own dedicated thread running at the same time. | Speed up task execution using multiple processors. |

🔹 **In short:**  
- **Concurrency = Dealing with many things at once.**  
- **Parallelism = Doing many things at once.**

---

###  Concurrency Models Overview

| Model | Description | Pros | Cons |
|--------|--------------|------|------|
| **Shared State Concurrency** | Multiple threads share objects and communicate via shared memory. | Simple conceptually, works well for small applications. | Prone to race conditions, deadlocks, hard to debug, requires careful synchronization. |
| **Separate State (Shared Nothing)** | Threads do not share objects; communication happens via messages or events. | Avoids most concurrency problems, safer and more predictable. | More complex design, requires message/event management. |
| **Blocking Concurrency Algorithms** | Threads may wait for resources, locks, or I/O to proceed. | Easier to implement and reason about. | Can hurt scalability due to thread contention and waiting. |
| **Non-Blocking Concurrency Algorithms** | Threads do not wait; use atomic operations, queues, or asynchronous mechanisms. | High scalability, avoids blocking, better performance. | Harder to implement and debug. |


---

###  Blocking vs Non-Blocking Concurrency Algorithms

| Type | Description | Example | Advantages | Disadvantages |
|------|--------------|----------|-------------|----------------|
| **Blocking** | A thread waits (is “blocked”) until a condition or resource is available. | `Thread.sleep()`, `wait()`, I/O operations. | Easier to reason about; deterministic order of events. | Wastes CPU cycles waiting, reduced scalability under load. |
| **Non-Blocking** | Threads never stop; they use retry mechanisms (like compare-and-swap) to make progress without waiting. | `AtomicInteger`, `ConcurrentLinkedQueue`, CAS operations. | High performance, no thread blocking, good for multi-core systems. | Complex to implement, risk of livelock or starvation. |

---

###  Example in This Project

| Mechanism | Where Used | Type |
|------------|-------------|------|
| `ExecutorService.newFixedThreadPool(K)` | Manages concurrent charging threads (each station). | **Thread-based parallelism** |
| `Thread.sleep()` | Simulates charging time delay. | **Blocking** concurrency |
| Dynamic assignment of AGVs | Managed via shared data structures with synchronization. | **Concurrent task scheduling** |

---

###  Summary

- **Concurrency** handles multiple AGVs *conceptually* at once.  
- **Parallelism** (via multiple threads) lets several AGVs *actually* charge simultaneously.  
- The project demonstrates a **blocking concurrency model** using `ExecutorService` and `Thread.sleep()` for time simulation.  
