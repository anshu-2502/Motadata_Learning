package main

import "fmt"

//here producer goroutine writes 0 to 9 to chnl channel and closes the channel
// main function has nfinite loop which checks channel is closed or not if closed the loop is broken

func producer(chnl chan int) {

	for i := 0; i < 10; i++ {
		chnl <- i
	}

	close(chnl)

}

func main() {

	ch := make(chan int)

	go producer(ch)

	//can replace this infinite loop with for range

	//for {
	//	v, ok := <-ch
	//
	//	if ok == false {
	//		break
	//	}

	//here the for range loop receives the data from ch until it is closed. once ch is closed loop exits.

	for v := range ch {

		fmt.Println("received,", v)
	}
}
