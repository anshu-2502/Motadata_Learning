package main

import "fmt"

func slicePanic() {
	n := []int{5, 6, 7}

	fmt.Println(n[4])
	fmt.Println("normally returned from a")

}

func main() {

	slicePanic()
	fmt.Println("norally returned from main")
}
