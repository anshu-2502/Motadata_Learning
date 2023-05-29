package main

import "fmt"

func main() {
	java := "java"

	switch java {
	case "java":
		fmt.Println("java me")
		fallthrough
	case "Java":
		fmt.Println("Ignored Case!")
	}

}
