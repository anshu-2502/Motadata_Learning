package main

import "fmt"

func main() {

	ch := make(chan string, 2)

	ch <- "anshu"
	ch <- "anushka"

	fmt.Println(<-ch)
	fmt.Println(<-ch)

}
