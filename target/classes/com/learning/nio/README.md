# Difference between NIO & I/O
NIO uses NIO buffers and channel oriented data flow for I/O operation. Also they use operating system for 
conventional I/O operations. This provides better performance.

IO uses stream line data flow, which involves converting data objects into bytes and vice versa. 
While NIO deals with data blocks which is chunks of bytes.

Stream line data flow in IO is unidirectional while NIO channel oriented data flow is bidirectional.
which mans same channel can be used for reading and writing data. 

NIO supports multithreading allowing reading and writing data asynchronously.

# Implementations of Channel
Java NIO uses channel to read data and write data (Bidirectional). Different class of channels are:

1. File channel- This channel is used for reading and writing data into file.
2. Datagram channel- This channel is used for reading and writing data over network using UDP protocol(User Datagram protocol)
3.	Socket Channel- This channel is used for reading and writing data over network using TCP protocol(Transmission control protocol)
4.	ServerScoketChannel- This channel is used for reading and writing data over TCP connection in web server. Each incoming request 	will have its own ServerSocketChannel.