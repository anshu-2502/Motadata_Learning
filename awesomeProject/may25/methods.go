package main

import "fmt"

type rect struct {
	width, height int
}

func (r *rect) area() int {
	return r.width * r.height
}

func (r *rect) perim() int {
	return 2 * (r.width + r.height)
}

func main() {

	rectangle := rect{width: 10, height: 5}

	fmt.Println("area", rectangle.area())

	fmt.Println("perim", rectangle.perim())

	pointer := &rectangle

	fmt.Println("area", pointer.area())

	fmt.Println("perim", pointer.perim())
}
