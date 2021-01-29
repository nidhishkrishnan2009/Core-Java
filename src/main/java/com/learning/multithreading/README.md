# Getting Started

1. Thread is a sub process. A process can have multiple threads.
2. Threads share same address space (same memory).
3. Context switching between thread is easy compared to process since process requires updating the registers,memory mapping.
4. Each process have its own memory/address space.

5.Threads are independent and an exception in one thread doesn't have any impact on another thread.

6.In multitasking using threads though threads executes parallel , at a time only one thread is executed.

# 4 states of Thread

1. new- state after a thread is created and before start() invocation.
2. Runnable- State before thread scheduler pick the created thread for execution and after start() method invocation.
3. Running - When thread scheduler pick for running the thread
4. Non-Runnable- when sleep or wait method is invoked.
5. Terminated- when stop() method is invoked or run method completes execution and thread is dead.