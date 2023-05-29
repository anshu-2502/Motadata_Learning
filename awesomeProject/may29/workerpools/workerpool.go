package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

// worker pool is collection of thread that are waiting for tasks to be assigned to them.
//Once they finish the task assigned, they make themselves available again for the next task.

//steps: 1~ creation of a pool of goroutines which listen on an input buffered channel waiting for jobs
//2~ addition of jobs to input buffered channel
//3~ writing results to an output buffered channel
//4~ read and print results from output buffered channel

type Job struct {
	id int

	randomnum int
}

type Result struct {
	job Job

	sumofdigits int
}

// create buffered channels for receiveing jobs and writing the output
var jobs = make(chan Job, 10)

var results = make(chan Result, 10)

//function digit does the actual job of finding the sum

func digits(number int) int {
	sum := 0
	no := number
	for no != 0 {
		digit := no % 10
		sum += digit
		no /= 10
	}
	time.Sleep(2 * time.Second)

	return sum
}

//worker goroutine

func worker(wg *sync.WaitGroup) {

	for job := range jobs {

		output := Result{job, digits(job.randomnum)}

		results <- output
	}

	wg.Done()
}

//creating worker pool

func createWorkerPool(noofworker int) {

	var wg sync.WaitGroup

	for i := 0; i < noofworker; i++ {
		wg.Add(1)
		go worker(&wg)
	}
}

//allocating jobs to workers:

func allocate(noofJObs int) {

	for i := 0; i < noofJObs; i++ {

		randomnum := rand.Intn(999)

		job := Job{i, randomnum}

		jobs <- job

	}
	close(jobs)
}

func result(done chan bool) {
	for result := range results {
		fmt.Printf("JOn id %d , input random numner %d, sum of digits %d \n", result.job.id, result.job.randomnum, result.sumofdigits)
	}

	done <- true
}

func main() {

	startTime := time.Now()

	noOfJobs := 100

	go allocate(noOfJobs)

	done := make(chan bool)

	go result(done)

	noOfWorkers := 10

	createWorkerPool(noOfWorkers)

	<-done

	endTime := time.Now()

	diff := endTime.Sub(startTime)

	fmt.Println("total time taken ", diff.Seconds(), "seconds")

}
