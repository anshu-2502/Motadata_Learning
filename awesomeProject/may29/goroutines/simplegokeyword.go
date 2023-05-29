package main

import (
	"fmt"
	"time"
)

func main() {
	go hello()

	time.Sleep(10 * time.Second)

	fmt.Println("main function")

}

func hello() {
	fmt.Println("hello world go routine")
}
