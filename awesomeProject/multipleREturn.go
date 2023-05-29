package main

import "fmt"

func vals() (int, int, int) {
	return 3, 7, 8
}

func main() {

	a, b, e := vals()
	fmt.Println(a)
	fmt.Println(b)
	fmt.Println(e)

	_, c, _ := vals()
	fmt.Println(c)

	d, _, e := vals()
	fmt.Println(d, e)
}
