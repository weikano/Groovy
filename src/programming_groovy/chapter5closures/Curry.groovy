def multiply = {x,y,z ->
    x*y*z
}
//curry就是将闭包中的参数按顺序替换成curry()中的参数
println multiply.curry(3,2)(3)