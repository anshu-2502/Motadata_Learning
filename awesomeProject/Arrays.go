package main

import "fmt"

func main() {

	var a [5]int
	fmt.Println("empty array:", a)

	a[4] = 100
	fmt.Println("setting a's 4th index as 100", a)
	fmt.Println("getting 4th index: ", a[4])

	fmt.Println("printing length: ", len(a))

	b := [5]int{1, 2, 3, 4, 5}

	fmt.Println("array", b)

	fmt.Println("---2-D Array----")

	var twoD [2][3]int

	for i := 0; i < 2; i++ {

		for j := 0; j < 3; j++ {

			twoD[i][j] = i + j

		}
	}

	fmt.Println("2d array:", twoD)

}
