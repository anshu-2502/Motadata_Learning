package main

import "fmt"

//arguments of a defered function are evaluated when a defer
//statement is executes not when actual function call is done

func main() {

	a := 5
	defer printA(a)

	a = 10
	fmt.Println("value of 'a' before deferred function call", a)

}

func printA(a int) {
	fmt.Println("value of a in deferred function", a)

}
