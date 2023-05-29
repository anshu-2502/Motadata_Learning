package main

import "fmt"

func main() {

	var a int = 5

	var s = &a

	fmt.Println("before changing: ", a)

	fmt.Println(s)

	*s = 7

	fmt.Println("after changing: ", a)
}
