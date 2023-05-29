package main

import (
	"fmt"
	"math"
)

const s string = "constant"

var v int = 89

func main() {

	fmt.Println(s)

	fmt.Println(v)

	const n = 500000000

	//const num = 67899/v

	var num = 67899 / v

	fmt.Println(num)

	const d = 3e20 / n

	fmt.Println(d)

	fmt.Println(int64(d))

	fmt.Println(math.Sin(n))

	fmt.Println(sum)
}
