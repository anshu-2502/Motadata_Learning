package main

import (
	"fmt"
	"time"
)

func main() {

	fmt.Println("-----first case-------")

	i := 2

	fmt.Println("write", i, "as")

	switch i {

	case 1:
		fmt.Println("one")
	case 2:
		fmt.Println("two")
	case 3:
		fmt.Println("three")

	}

	fmt.Println("-----week case-------")

	switch time.Now().Weekday() {

	case time.Saturday, time.Sunday:
		fmt.Println("weekend")
	default:
		fmt.Println("weekdays")

	}

	t := time.Now()

	switch {

	case t.Hour() < 12:

		fmt.Println("it's before noon")

	default:

		fmt.Println("its afternoon")

	}

	fmt.Println("-----A TYPE SWITCH-------")

	whatAmI := func(i interface{}) {

		switch t := i.(type) {

		case bool:
			fmt.Println("boolean")

		case int:
			fmt.Println("integer")

		default:
			fmt.Println("don't know the type", t)

		}
	}

	whatAmI(true)

	whatAmI(1)

	whatAmI("anshu")

}
