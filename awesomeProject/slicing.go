package main

import "fmt"

func main() {

	var s []string

	fmt.Println("uninit:", s, s == nil, len(s) == 0)

	s = make([]string, 3)
	fmt.Println("empty:", s, "length:", len(s), "capacity:", cap(s))

	s[0] = "a"
	s[1] = "b"
	s[2] = "c"

	fmt.Println("after setting value set: ", s)

	fmt.Println("get particular index:", s[1])

	fmt.Println("len:", len(s))

	s = append(s, "d")

	s = append(s, "e", "f")

	fmt.Println("after appending the value in string (def):", s)

	c := make([]string, len(s))
	copy(c, s)
	fmt.Println("copied: ", c)

	l := s[2:5]
	fmt.Println("sl1:", l)

	l = s[:5]
	fmt.Println("sl2", l)

	l = s[2:]
	fmt.Println("sl3", l)

	t := []string{"g", "h", "i"}

	fmt.Println("duplicate: ", t)

	twoD := make([][]int, 3)

	for i := 0; i < 3; i++ {

		innerLen := i + 1

		twoD[i] = make([]int, innerLen)

		for j := 0; j < innerLen; j++ {

			twoD[i][j] = i + j

		}

	}

	fmt.Println("2d: ", twoD)

}
