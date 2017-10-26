Ben Anding bpa4503 C00171534
CMPS 261
Project 7

Linear Probing
{0=0, 1=0, 2=0, 3=71, 4=0, 5=73, 6=23, 7=39, 8=0, 9=43, 10=61, 11=44, 12=0, 13=13, 14=99, 15=0, 16=16}

Quadratic Probing
{0=0, 1=0, 2=39, 3=71, 4=0, 5=73, 6=23, 7=0, 8=0, 9=43, 10=61, 11=44, 12=0, 13=13, 14=99, 15=0, 16=16}

Double Hashing
{0=0, 1=44, 2=0, 3=71, 4=0, 5=73, 6=23, 7=39, 8=0, 9=43, 10=61, 11=0, 12=0, 13=13, 14=99, 15=0, 16=16}

Separate Chaining
{0=[], 1=[], 2=[], 3=[71], 4=[], 5=[73, 39], 6=[23], 7=[], 8=[], 9=[43], 10=[61, 44], 11=[], 12=[], 13=[13], 14=[99], 15=[], 16=[16]}

Linear probing is advantageous due to the simplicity of its implementation. A major disadvantage of linear probing is an uneven data distribution that leads to clustering or clumping. 

Quadratic probing, similar to linear probing, is simple to implement and is not computation heavy. Likewise, although the distribution is better than that of a linear probing approach, data distribution will still tend towards clusters or clumps.

Double hasing is advantageous in that it has an improved data distribution as it handles collisions more elegantly than its probing counterparts. The introduction of a secondary hash function increases the amount of computations that must occur during hashing however. 

Separate chaining is advantageous in that hashed objects are stored logically and collisions can practically be ignored. However, this approach requires additional memory space as separate lists must be maintained for each position in the table.

ULL GPL License 2017
