package main

import "fmt"

func main() {

	fmt.Println("way one:--")

	var i int = 1

	for i <= 3 {

		fmt.Println("first-way", i)

		i = i + 1
	}

	fmt.Println("way two:--")

	for j := 7; j <= 9; j++ {

		fmt.Println(" secondway", j)
	}

	//infinite loop:
	for {
		fmt.Println("loop")
		break

	}

	fmt.Println("odd numbers")
	for n := 0; n <= 5; n++ {

		if n%2 == 0 {

			continue
		}

		fmt.Println(n)
	}

}
