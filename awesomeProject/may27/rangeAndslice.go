package main

import "fmt"

func main() {

	var a []int = []int{1, 2, 3, 4, 5, 4, 61}

	//for i := 0; i < len(a); i++ {
	//
	//	fmt.Println(a[i])
	//
	//}

	//range a returns the index and the element inside slice of array
	//for i, element := range a {
	//
	//	fmt.Printf("%d: %d\n", i, element)
	//
	//}

	//removing duplicate

	for i, element := range a {
		for _, element2 := range a[i+1:] {
			if element == element2 {
				fmt.Println(element)
			}
		}

	}

}
