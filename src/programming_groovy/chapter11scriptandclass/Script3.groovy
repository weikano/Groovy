println "Script3"
binding1 = new Binding()
binding1.setProperty('name','Verket')
shell = new GroovyShell(binding1)
shell.evaluate(new File("Script1a.groovy"))

binding2 = new Binding()
binding2.setProperty("name","Ben")
shell = new GroovyShell(binding2)
println shell.evaluate(new File("Script1a.groovy"))


