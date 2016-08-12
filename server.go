package main

import "github.com/kataras/iris"

func hi(ctx *iris.Context) {
   ctx.Write("Howdy CodePrixers")
}

func main() {
    api := iris.New()

    api.Get("/hi", hi)

    api.Listen(":8080")
}
