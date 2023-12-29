# Compression Algorithm Project

## Description

This project implements a compression algorithm that saves space by storing repeated data as a single value, along with the number of times it's repeated. The algorithm uses the ± symbol as a separator between the frequency and the character itself. For example, the string "AAAAABBB#####" can be compressed to "A±5B±3#±5".

ABC will be compressed to A±1B±1C±1 to avoid situation where A±21 could be AA1.

## Usage

To use the compression and decompression functionality provided by this project, follow the steps below:

1. Clone or download the project.
2. Build and compile the project using gradle.
3. Run the program and provide the necessary input data for compression or decompression.
4. View the output, which will be the compressed or decompressed data.
5. You can use interaction via console to evaluate the data

## Testing

The project includes a suite of unit tests. You are free to run them using gradlew test
