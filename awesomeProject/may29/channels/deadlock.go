package main

import "fmt"

//unidirectional channel:

func sendData(sendch chan<- int) {
	sendch <- 10
}

func main() {

	//ch := make(chan int)
	//
	//ch <- 5

	//sendch := make(chan<- int)

	//bidirectional channel is created

	sendch := make(chan int)

	go sendData(sendch)

	fmt.Println(<-sendch)

}
