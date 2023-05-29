package main

import "fmt"

type Radius interface {
	int64 | int8 | float64
}

func circumference[R Radius](radius R) {
	var c R

	c = 2 * 3 * radius

	fmt.Println("circumference is", c)
}

func main() {

	var radius2 float64 = 9.5

	circumference(radius2)
}
