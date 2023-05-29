package main

import (
	"fmt"
	"math"
)

type geometery interface {
	area() float64
	perim() float64
}

type rec struct {
	width, height float64
}

type circle struct {
	radius float64
}

func (r rec) area() float64 {
	return r.width * r.height
}

func (r rec) perim() float64 {
	return 2*r.width + 2*r.height
}

func (c circle) area() float64 {
	return math.Pi * c.radius * c.radius
}
func (c circle) perim() float64 {
	return 2 * math.Pi * c.radius
}

func measure(g geometery) {
	fmt.Println(g)
	fmt.Println(g.area())
	fmt.Println(g.perim())
}

func main() {

	r := rec{width: 3, height: 5}
	c := circle{radius: 3}

	measure(r)
	measure(c)

}
