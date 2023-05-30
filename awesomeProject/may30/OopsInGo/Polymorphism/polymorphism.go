package main

import "fmt"

type Income interface {
	calculate() int
	source() string
}

type FixedBilling struct {
	projectName  string
	biddedAmount int
}

type TimeAndMaterial struct {
	projectName string
	noOfHours   int
	hourlyRate  int
}
type Advertisement struct {
	adName string

	CPC int

	noOfCLicks int
}

//calculating and return actual income and source of income

func (fb FixedBilling) calculate() int {
	return fb.biddedAmount
}

func (fb FixedBilling) source() string {
	return fb.projectName
}

func (tm TimeAndMaterial) calculate() int {
	return tm.noOfHours * tm.hourlyRate
}

func (tm TimeAndMaterial) source() string {
	return tm.projectName
}

func (a Advertisement) calculate() int {
	return a.CPC * a.noOfCLicks
}

func (a Advertisement) source() string {
	return a.adName

}

// accepts slice of income as arguments.It calculates total income by iterating over slics
// and calling calculate() method on each of its items

func calculateNetIncome(ic []Income) {
	var netincome int = 0
	for _, income := range ic {
		fmt.Printf("income from %s = $%d\n", income.source(), income.calculate())

		netincome = netincome + income.calculate()
	}

	fmt.Printf("netincome of organisation: $%d", netincome)
}

func main() {

	project1 := FixedBilling{projectName: "project1", biddedAmount: 8000}

	project2 := FixedBilling{projectName: "project2", biddedAmount: 10000}

	project3 := TimeAndMaterial{projectName: "project-3", noOfHours: 160, hourlyRate: 25}

	bannerAd := Advertisement{adName: "nirma", CPC: 2, noOfCLicks: 500}

	popUpAd := Advertisement{adName: "ad2", CPC: 5, noOfCLicks: 110}

	incomeStreams := []Income{project1, project2, project3, bannerAd, popUpAd}

	calculateNetIncome(incomeStreams)
}
