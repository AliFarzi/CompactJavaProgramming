# Fully Automated Storage System

## 📦 Overview
This project is a **Fully Automated Storage System**, designed to simulate how an automated warehouse manages items, equipment, and logs.  
It demonstrates a modular architecture in Java, where each team member is responsible for a separate component of the system, all integrated together to simulate the entire lifecycle of storage management.

Screencast: https://drive.google.com/file/d/12G-Zi285l3kJfkctonhq37yGpHu6VM5r/view?usp=sharing

---

## 🧩 Project Modules

### 1. Storage Module (Usman Rangrez)
Handles the **core storage logic** — responsible for managing storage cells, item placements, and retrieval operations.  
It simulates how items are stored in specific cells and how the system ensures optimal space utilization and retrieval accuracy.  
Key features:
- Dynamic cell allocation and release  
- Item–cell mapping and position tracking (X, Y, Z coordinates)  
- Exception handling for overcapacity (e.g., `StorageFullException`)  
- Integration points for task execution and equipment requests  

---

### 2. Equipment Module (Ali Shaaban)
Handles **equipment simulation**, including the movement of mechanical components (robots, agv, etc.) required to perform storage and retrieval.  
This module communicates with the Storage module to execute item movements based on the current task.

---

### 3. Logging Module (Priyanka)
Responsible for **system logging and lifecycle monitoring**.  
It tracks all system activities such as storage actions, equipment usage, and errors.  
The module provides a visual simulation of the storage lifecycle.

#### ▶️ How to Run
1. Navigate to the `Homework1/LoggingModule` folder.  
2. Run `LogApp.java`.  
   - This demonstrates the lifecycle and behavior of logs in the system.

---

### 4. Task Module (Ali Farzizada - Integration)
This is the **central integration layer** that connects all modules together.  
It defines and executes tasks that involve storage, equipment, and logging coordination.  
The `TaskModule` acts as the main simulation runner for the entire system.

#### ▶️ How to Run Integration
1. Open the `TaskModule` folder.  
2. Run `TestStorageUsage.java`.  
   - This will launch a simulation of the full project, showing how all modules work together.

---

## ⚙️ Technologies Used
- **Java**
- **Object-Oriented Design**
- **Custom Exceptions & Lifecycle Simulation**

---

## 👥 Team Members
| Name | Module | Responsibilities |
|------|---------|------------------|
| **Usman Rangrez** | Storage Module | Handles storage logic, item-cell allocation, and exception handling |
| **Ali Shaaba** | Equipment Module | Simulates equipment and mechanical interactions |
| **Priyanks** | Logging | Handles logging, system monitoring,  |
| **Ali Farzizada** | Integration | TaskModule and task orchestration (API integration) |

---

## 🚀 Simulation Flow
1. **Storage Module** defines and manages available cells and storage logic.  
2. **Equipment Module** performs physical operations for item placement/retrieval.  
3. **Logging Module** tracks each lifecycle event.  
4. **Task Module** integrates all and triggers end-to-end simulation.  

---

## 🧠 Summary
This project models how a **fully automated warehouse system** operates — from storage logic to equipment movement and full system logging.  
Each submodule operates independently but interacts seamlessly during the simulation!

---
