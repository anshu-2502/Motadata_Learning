package main

import "fmt"

func calcSquares(number int, squareop chan int) {

	sum := 0
	for number != 0 {
		digit := number % 10
		sum = sum + (digit * digit)
		number /= 10
	}

	squareop <- sum

}

func calcCubes(number int, cubeop chan int) {
	sum := 0

	for number != 0 {
		digit := number % 10
		sum += digit * digit * digit
		number /= 10
	}

	cubeop <- sum
}

func main() {

	number := 589

	sq := make(chan int)

	cube := make(chan int)

	go calcSquares(number, sq)

	go calcCubes(number, cube)

	squares, cubes := <-sq, <-cube

	fmt.Println("final output: squares+cubes", squares+cubes)
}
