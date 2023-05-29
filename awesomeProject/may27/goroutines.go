package main

import (
	"fmt"
	"time"
)

func message(mess string) {

	for i := 0; i < 5; i++ {
		fmt.Println("simple message= ", mess, " ", i)
	}

}

func message2(mess string) {

	for i := 0; i < 5; i++ {
		fmt.Println("go threads= ", mess, " ", i)
	}

}

func main() {

	go message("anshu")

	message("no thread")

	go message2("anushka")

	time.Sleep(time.Second)

}
