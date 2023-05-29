package main

import (
	"fmt"
	"runtime"
	"time"
)

func main() {

	go hello()

	msg := "hello"

	msg = "hello"
	go func(msg1 string) {
		fmt.Println(msg1)
	}(msg) // value passed in while invoking message
	msg = "goodbye"

	time.Sleep(100 * time.Millisecond)

	// Number of CPU threads available
	// By default equal to the number of cores on the machine
	runtime.GOMAXPROCS(1)
	fmt.Printf("Threads: %v\n", runtime.GOMAXPROCS(-1))
}

func hello() {
	fmt.Println("Hello form hello function!")
}
