package main

import "fmt"

func main() {

	//string=key type ,, int =value type

	maps := make(map[string]int)

	maps["k1"] = 7
	maps["k2"] = 10

	fmt.Println("map: ", maps)

	value1 := maps["k1"]
	fmt.Println("value1: ", value1)

	value2 := maps["k2"]
	fmt.Println("value2:", value2)

	value3 := maps["k3"]
	fmt.Println("value3:", value3)

	fmt.Println("length:", len(maps))

	delete(maps, "k2")
	fmt.Println("maps", maps)

	_, present := maps["k2"]

	fmt.Println("present: ", present)

	map2 := map[string]int{"foo": 1, "bar": 2}
	fmt.Println("map:", map2)
}
