gRPC vs Spring Rest Microbenchmark
==================================

This project is an implementation of the simplest (in terms of implementation) possible microbenchmark that compares a single server synchronously echo'ing of data, with one request in flight at a time.

Both the client and server run in one process, communicating over localhost. That leaves the following areas to be measured by the microbenchmark:

* Serialization and Deserialization (JSON vs protobuf)
* Framework Overhead (Spring Rest vs gRPC)

Running the Benchmark
---------------------

You can run this benchmark locally by cloning this repository, and then running `mvn spring-boot:run`. 

This will start the servers and execute both benchmarks. Each benchmark is executed 10 times. Each time, it runs 20 warmup iterations, and then 20 iterations to capture results. At the end, aggregated results are printed, and the application exits.

Results
-------

Running on my desktop (Windows 10, Intel i7-4790K), here were the results:

```
Benchmark                   Mode  Cnt     Score    Error  Units
GrpcBenchmark.callService  thrpt  200  3536.438 ± 40.681  ops/s
RestBenchmark.callService  thrpt  200  1895.349 ± 25.321  ops/s
```

Qualitatively, both benchmarks fully utilize a single CPU core (since only a single concurrent request is used, this is basically the cap). That implies both suites are CPU constrained, and that gRPC+protobuf is 2x faster/cpu efficient as Spring Rest+JSON.