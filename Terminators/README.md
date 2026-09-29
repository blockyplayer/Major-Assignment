# Some project ideas



### The following are some project ideas for the Como1010 major assignment.

* **A Sim game**, where a person must keep their Sim happy. A Sim's happiness decreases with time, so the user must select a category, then a task, to make their Sim happier. Under specific circumstances, a task that would usually contribute positively to happiness might actually decrease happiness (for example, if a Sim has a bad relationship with a character, then socialising with this character would have an adverse effect). Characters are pre-defined for simplicty, with a personality and relationship with the Sim. File I/O could be used to save game, or to load personalities? Seems pretty basic...

* **A species game**, where a person is tasked with keeping the population of a species above a certain thereshehold (could be greater than other populations, or just above a diffuclty-determined thereshehold that is not determined by gameplay). The user chooses a set of animals (rabbit, fox, or bird maybe), and based on the selection, another set of predators is allocated. If predator population grows, the user's population decreases. If the user's population increases, the rate of increase does too (exponential), but nothing happens to predators (maybe). All species have the same 

* **A calculator** that has different modes (classes) for drawing graphs, doing arithmetic, or creating a table file I/O csv. Vectors, phyiscs, []. 

* **A robot** The user controls a robot army through this program. The number of robots to control is based on the difficulty. Only one robot is attacked at a time. When a robot receives an attack, the user is prompted to either fight, dodge, or sacrifice. A fight is sucesseful if the robot has more health and sufficient attack damage with no cooldowns in place. A dodge is sucessful if the last 2 robot actions were not dodges. A sacrifice ensures mutual desturction, so the robot is also destroyed. A robot can not be attacked if it was already attacked during the last round.
Therefore, there are 3 classes. Enemy, robot, and main. 
There are a minimum of 2 objects. One enemy, one robot (Attributes of the enemy can be randomised, with limits, and with a minimum health that increases as gameplay progresses).
Each robot has the following methods:
* * robot1.attack(damage/*The amount of damage dealt to the enemy*/, health/*The amount of health the robot has initially*/, attackType */The type of attack. Can be missiles, laser eyes, or basic shoot. Each attack has a specific cooldown, so attack history has to be saved to a file.*/);
* * robot1.dodge();
* * robot1.sacrifice();
Each enemy has the following methods (there is only one during gameplay, with dynamic attributes):
* * enemy.attack(robotSelection/*The robot that has been selected*/, damage/*The damage dealt to the robot*/, health */ The initial health*/);

Is the enemy just another robot?


### The program is very very simple at the moment
It will, however, grow in complexity. I've just done some basic object interactions, and some fileIO taken directly from Professor Gupta's example here: https://ilearn.mq.edu.au/mod/forum/discuss.php?d=2850424#p8848270.

I plan on adding difficulty levels, an arraylist of objects, and more advanced interactions. I am not quite sure if this is enough to cut it in terms of the marking criteria, even after these additions, so I would appreciate feedback on project scope, and exaclty what I need in order to pass.

Thank you.
