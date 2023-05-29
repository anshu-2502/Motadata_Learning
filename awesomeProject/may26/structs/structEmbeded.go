package main

import "fmt"

type base struct {
	num int
}

func (b base) describe() string {
	return fmt.Sprintf("base with num= %v", b.num)
}

type container struct {
	anshu base

	str string
}

type box struct {
	anushka base

	container

	str2 string
}

func main() {

	nestedstruct := box{
		anushka: base{num: 2},
		container: container{
			anshu: base{num: 3},

			str: "inside container inside box",
		},

		str2: "inside box struct",
	}

	fmt.Printf("nest={num: %d , num: %d string: %v , string: %v}\n", nestedstruct.anushka.num, nestedstruct.container.anshu.num, nestedstruct.str, nestedstruct.str2)

	//co := container{
	//
	//	abshu: base{
	//
	//		num: 1,
	//	},
	//
	//	str: "anshu",
	//}
	//
	//fmt.Printf("co={num: %v, string:%v}\n", co.num, co.str)
	//
	//fmt.Println("also num:", co.base.num)
	//
	//fmt.Println("describe: ", co.describe())

	type describer interface {
		describe() string
	}

	//var d describer = co

	//fmt.Println("describer: ", d.describe())

}
