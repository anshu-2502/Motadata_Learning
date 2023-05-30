package main

import (
	"fmt"
	"sync"
)

var x = 0

func increment(wg *sync.WaitGroup, m *sync.Mutex) {

	m.Lock()

	x = x + 1

	m.Unlock()

	wg.Done()
}

func main() {

	var m sync.Mutex

	var w sync.WaitGroup

	for i := 0; i < 1000; i++ {

		w.Add(1)

		go increment(&w, &m)
	}

	w.Wait()

	fmt.Println("final value of x, ", x)

}
