package main

import (
	"fmt"
	"sync"
	"time"
)

//wait group: is used to wait for collection of go routines to finish
//executing. the control is blocked until all go routines finish executing
//wait group is struct type.

func process(i int, wg *sync.WaitGroup) {

	fmt.Println("started go-routine", i)

	time.Sleep(2 * time.Second)

	fmt.Printf("goroutine %d ended\n", i)

	wg.Done()

}

func main() {

	number := 3

	var wg sync.WaitGroup

	for i := 0; i < number; i++ {

		//when we call add on the waitgroup amd pass it an int the waitgroup counter is incremented
		//by value passed to add,
		//decrement is done by done method on waitgroup
		//the wait method blocks the goroutine in which its called until counter becomes zerp

		wg.Add(1)

		//It is important to pass the pointer of wg .
		//If the pointer is not passed,
		//then each Goroutine will have its own copy of the WaitGroup and
		//main will not be notified when they finish executing.
		go process(i, &wg)
	}

	wg.Wait()
	fmt.Println("all go routines finished executing")

}
