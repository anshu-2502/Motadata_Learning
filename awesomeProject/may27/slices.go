package main

import "fmt"

func main() {

	var x [5]int = [5]int{1, 2, 3, 4, 5}

	var s []int = x[2:5]

	fmt.Println(s)

	var s2 []int = s[1:3]

	fmt.Println(s2)

	//slice and arrays declaration are almost the same just we dont provide the number of elements in slice

	var slice []int = []int{1, 2, 3, 4, 5, 6, 7}

	//adding elem to slice:

	slice = append(slice, 10) //returns a new slice

	fmt.Println(slice)

	//slice with make

	a := make([]int, 5)

	fmt.Println(a)

}
