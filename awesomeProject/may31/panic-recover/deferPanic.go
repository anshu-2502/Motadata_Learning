package main

import "fmt"

func fullname(firstName *string, lastName *string) {
	defer fmt.Println("deferred call in fullName")
	if firstName == nil {
		panic("runtime error: firstname cannot be nil")
	}

	if lastName == nil {
		panic("runtime error: last name cannot be nil ")
	}

	fmt.Println("%s%s\n", *firstName, *lastName)
	fmt.Println("returned normally from full name")
}

func main() {
	defer fmt.Println("deferred call in main")
	firstName := "Elon"
	fullname(&firstName, nil)
	fmt.Println("returned normally from main")
}
