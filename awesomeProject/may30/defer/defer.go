package main

import "fmt"

func finished() {
	fmt.Println("finished finding largest")
}

func largest(nums []int) {

	defer finished()

	fmt.Println("started finding largest")

	max := nums[0]

	for _, v := range nums {
		if v > max {
			max = v
		}
	}

	fmt.Println("largest number in", nums, "is", max)
}

func main() {

	nums := []int{23, 56, 43, 56, 77}
	largest(nums)

}
