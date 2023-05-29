package main

import "fmt"

type rectangle struct {
	length  int
	breadth int
	color   string
}

func main() {

	var rect1 = rectangle{10, 20, "green"}
	fmt.Println(rect1)

	var rect2 = rectangle{length: 10, color: "green"}
	fmt.Println(rect2)

	rect3 := rectangle{10, 20, "Green"}
	fmt.Println(rect3)

	rect4 := rectangle{length: 10, breadth: 20, color: "Green"}

	fmt.Printf("%+v", rect4)
	fmt.Println()

	rect5 := rectangle{breadth: 20, color: "Green"}
	fmt.Println(rect5)

}
