This repository contains a JAVA code implementation for the Particle Swarm Optimization (PSO) algorithm in solving the N-Queens problem.

Classes include:

Particle.java- class which contains the solutions.
ParticleSwarmOptimization.java - class which implements the PSO algorithm for N-Queens. Algorithm parameters are defined here.
Writer.java - class which holds a string list to be written in a log file.
TesterPSO.java - class which runs the tests and invokes the creation of the log file. 

How to use:

Install JAVA JDK.
Compile and run TesterPSO.java along with its required classes in your preferred editor.

Sample log file:

PSO-N4-4.0-1000.txt

Particle Swarm Optimization Algorithm
Parameters
MAX_LENGTH/N: 4
STARTING_POPULATION: 40
MAX_EPOCHS: 1000
MAX_VELOCITY: 4.0
MINIMUM_SHUFFLES: 8
MAXIMUM_SHUFFLES: 20

Run: 1
Runtime in nanoseconds: 38167312
Found at epoch: 1
Population size: 40

. . Q . 
Q . . . 
. . . Q 
. Q . . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

Run: 2
Runtime in nanoseconds: 18812173
Found at epoch: 1
Population size: 40

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. . Q . 
Q . . . 
. . . Q 
. Q . . 

Run: 3
Runtime in nanoseconds: 51481481
Found at epoch: 1
Population size: 40

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 

. . Q . 
Q . . . 
. . . Q 
. Q . . 

. . Q . 
Q . . . 
. . . Q 
. Q . . 

. Q . . 
. . . Q 
Q . . . 
. . Q . 



...