package main

import "fmt"

func generic_circumference[r int | float64](radius r) {

	circum := 2 * 3 * radius

	fmt.Println("the circumference is: ", circum)

}
func main() {

	var radius1 int = 8
	var radius2 float64 = 9.5

	generic_circumference(radius1)
	generic_circumference(radius2)

}
