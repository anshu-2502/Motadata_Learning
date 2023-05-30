package main

import (
	"fmt"
	"sync"
)

var count = 0

func increase(wg *sync.WaitGroup, ch chan bool) {

	//passing true to buffered channel before increment
	//to ensure only one go routine access critical section of code

	ch <- true

	count = count + 1

	<-ch

	wg.Done()
}
func main() {

	var w sync.WaitGroup
	ch := make(chan bool, 1)

	for i := 0; i < 1000; i++ {
		w.Add(1)
		go increase(&w, ch)
	}

	w.Wait()
	fmt.Println("final value of x", count)

}
