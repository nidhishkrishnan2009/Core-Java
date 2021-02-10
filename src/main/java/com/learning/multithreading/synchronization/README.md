# Thread Synchronization

Synchronization is a capability to control access of multiple threads to shared resource. 

# 2 Types of thread synchronization

- Mutual exclusive
- Inter-thread communication

Different ways to achieve Mutual exclusive

- Synchronized method 
- Synchronized block
- static synchronization

# Concept of Locks in Thread synchronization

Synchronization is built on internal entity known as lock. Every object has an internal entity (i.e) lock associated with it. If the method is method is synchronized then calling thread will acquire the lock first and when it is done it will release the lock.No other threads can execute a synchronized resource until existing lock is released and the same lock is acquired. 