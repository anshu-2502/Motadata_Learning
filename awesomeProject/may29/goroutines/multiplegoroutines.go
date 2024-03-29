package main

import (
	"fmt"
	"time"
)

func numbers() {
	for i := 1; i <= 5; i++ {
		time.Sleep(250 * time.Millisecond)
		fmt.Printf("%d", i)
		fmt.Println()
	}
}

func alphabets() {

	for i := 'a'; i <= 'e'; i++ {

		time.Sleep(500 * time.Millisecond)

		fmt.Printf("%c", i)
		fmt.Println()
	}
}

func main() {

	go numbers()

	go alphabets()

	time.Sleep(3000 * time.Millisecond)

	fmt.Println("main terminated")

}
