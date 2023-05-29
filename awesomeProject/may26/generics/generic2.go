package main

import "fmt"

func find[T comparable](arr []T, val T) int {
	for i, v := range arr {
		if v == val {
			return i
			//range a returns the index and the element inside slice of array
			//for i, element := range a {
			//
		}
	}

	return -1
}

func swap[T any](x, y T) (T, T) {
	return y, x
}

func main() {

	//find --------------
	arr := []int{1, 2, 3, 4, 5}

	index := find(arr, 3)

	fmt.Println(index)

	arr2 := []string{"foo", "bar", "baz"}
	index2 := find(arr2, "bar")
	fmt.Println(index2)

	//swap------------

	a, b := 1, 2
	a, b = swap(a, b)
	fmt.Println(a, b)

	c, d := "hello", "world"
	c, d = swap(c, d)
	fmt.Println(c, d)
}
