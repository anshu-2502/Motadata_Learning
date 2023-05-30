package main

import "fmt"

// composition by embedding structs instead of inheritance

type author struct {
	firstName string
	lastName  string
	bio       string
}

func (a author) fullName() string {
	return fmt.Sprintf("%s %s", a.firstName, a.lastName)
}

type blogPost struct {
	title   string
	content string
	author
}

func (b blogPost) details() {
	fmt.Println("Title: ", b.title)
	fmt.Println("Content: ", b.content)
	fmt.Println("author: ", b.author.fullName())
	fmt.Println("Bio:", b.author.bio)

}

type website struct {
	blogPosts []blogPost
}

func (w website) contents() {
	fmt.Println("contents of website")

	for _, v := range w.blogPosts {

		v.details()
		fmt.Println()
	}
}
func main() {

	author1 := author{
		"Anshu",
		"Sharma",
		"everything happens for a reason",
	}

	blogPost1 := blogPost{
		"inheritance",
		"go supports instead of inheritance",
		author1,
	}
	blogPost2 := blogPost{
		"Struct instead of Classes in Go",
		"Go does not support classes but methods can be added to structs",
		author1,
	}
	blogPost3 := blogPost{
		"Concurrency",
		"Go is a concurrent language and not a parallel one",
		author1,
	}

	w := website{
		blogPosts: []blogPost{blogPost1, blogPost2, blogPost3},
	}

	w.contents()

	//blogPost1.details()

}
