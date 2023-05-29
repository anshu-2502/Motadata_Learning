package main

import "fmt"

type Example struct {
	X int
	Y int
}

func main() {

	v := Example{1, 2}

	p := &v

	p.Y = 1e9

	fmt.Println(v)

}
